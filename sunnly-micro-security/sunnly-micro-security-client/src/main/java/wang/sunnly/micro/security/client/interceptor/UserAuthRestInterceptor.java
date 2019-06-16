package wang.sunnly.micro.security.client.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

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

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return super.preHandle(request, response, handler);
    }
}
