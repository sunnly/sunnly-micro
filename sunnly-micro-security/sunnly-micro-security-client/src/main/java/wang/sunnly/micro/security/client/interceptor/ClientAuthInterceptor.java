package wang.sunnly.micro.security.client.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import wang.sunnly.micro.security.client.annotation.IgnoreClientToken;
import wang.sunnly.micro.security.client.configuration.SecurityAuthClientConfig;
import wang.sunnly.micro.security.core.properties.SecurityProperties;
import wang.sunnly.micro.security.core.status.SecurityStatus;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.utils.jwt.IJWTInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 服务鉴权拦截器
 * @author Sunnly
 * @ClassName ServiceAuthRestInterceptor
 * @Date 2019/6/12 0012 20:15
 **/
public class ClientAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private SecurityAuthClientConfig securityAuthClientConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取IgnoreServiceToken注解
        IgnoreClientToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreClientToken.class);
        if (annotation == null){
            annotation = handlerMethod.getMethodAnnotation(IgnoreClientToken.class);
        }
        if (annotation != null){
            //配置了不需要验证的注解，直接放行
            return super.preHandle(request, response, handler);
        }
        //未配置忽略注解，判断是否在配置中进行
        //获取header中的token,key值从配置文件sunnly.security.auth.client.token-header中获取
        String tokenKey = securityProperties.getAuth().getClient().getTokenHeader();
        if (StringUtils.isEmpty(tokenKey)){
            throw new SecurityTokenException(SecurityStatus.CLIENT_TOKEN_HEADER_NOT_CONFIG);
        }
        //获取请求头中的token,当服务鉴权时，Feign请求时将携带自己的token过来请求
        String token = request.getHeader(tokenKey);

        if(StringUtils.isEmpty(token)){
            throw new SecurityTokenException(SecurityStatus.TOKEN_EMPTY);
        }
        //解析请求头中的token，服务端token需要通过公钥解析，从鉴权服务器获取公钥
        IJWTInfo infoFromToken = securityAuthClientConfig.getInfoFromToken(token);
        String uniqueName = infoFromToken.getUniqueName();
        for (String client : securityAuthClientConfig.getAllowedClient()){
            if (StringUtils.equals(client, uniqueName)){
                return super.preHandle(request, response, handler);
            }
        }
        throw new SecurityTokenException(SecurityStatus.CLIENT_FORBIDDEN);
    }

}
