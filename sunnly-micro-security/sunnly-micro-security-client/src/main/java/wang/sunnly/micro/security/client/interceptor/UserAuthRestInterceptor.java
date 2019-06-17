package wang.sunnly.micro.security.client.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import wang.sunnly.micro.common.core.handler.BaseThreadLocalHandler;
import wang.sunnly.micro.security.client.annotation.IgnoreUserToken;
import wang.sunnly.micro.security.client.configuration.SecurityAuthClientConfig;
import wang.sunnly.micro.security.client.properties.SecurityProperties;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;
import wang.sunnly.micro.security.core.utils.jwt.IJWTInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 用户鉴权拦截器
 * @author Sunnly
 * @ClassName UserAuthRestInterceptor
 * @Date 2019/6/12 0012 20:15
 **/
public class UserAuthRestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SecurityAuthClientConfig securityAuthClientConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
        if (annotation == null) {
            annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
        }
        if (annotation != null) {
            return super.preHandle(request, response, handler);
        }

        String tokenKey = securityProperties.getAuth().getUser().getTokenHeader();
        if (StringUtils.isEmpty(tokenKey)){
            throw new SecurityTokenException(SecurityStatus.USER_TOKEN_HEADER_NOT_CONFIG);
        }
        String token = request.getHeader(tokenKey);

        if(StringUtils.isEmpty(token)){
            //从cookies中取
            if (request.getCookies() !=null){
                for (Cookie cookie : request.getCookies()){
                    if (StringUtils.equals(cookie.getName(),tokenKey)){
                        token = cookie.getValue();
                    }
                }
            }
        }
        IJWTInfo infoFromToken = securityAuthClientConfig.getInfoFromToken(token);
        //保存到本地线程存储中    ,Feign拦截器中就可以获取这些信息了
        BaseThreadLocalHandler.setUsername(infoFromToken.getUniqueName());
        BaseThreadLocalHandler.setName(infoFromToken.getName());
        BaseThreadLocalHandler.setUserID(infoFromToken.getId());

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //处理完成后清楚线程存储
        BaseThreadLocalHandler.remove();
        super.afterCompletion(request, response, handler, ex);
    }
}
