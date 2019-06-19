package wang.sunnly.micro.security.client.interceptor;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import wang.sunnly.micro.common.core.constants.BaseThreadLocalConstants;
import wang.sunnly.micro.common.core.handler.BaseThreadLocalHandler;
import wang.sunnly.micro.security.client.configuration.SecurityAuthClientConfig;
import wang.sunnly.micro.security.core.properties.SecurityProperties;

import java.io.IOException;

/**
 *
 * 拦截Feign请求，在header中加入token，
 * 服务器端才可以获取到用户鉴权和服务鉴权
 * @author Sunnly
 * @ClassName FeignHttpInterceptor
 * @Date 2019/6/17 16:51
 * @Version 1.0
 */
@Component
public class FeignOkHttpInterceptor implements Interceptor {

    @Autowired
    @Lazy
    private SecurityProperties securityProperties;

    @Autowired
    @Lazy
    private SecurityAuthClientConfig securityAuthClientConfig;

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request().url().toString().contains("client/token") ?
                chain.request().newBuilder()
                        .header(securityProperties.getAuth().getUser().getTokenHeader(),
                                BaseThreadLocalHandler.getToken())
                        .build()
                :
                chain.request().newBuilder()
                        .header(securityProperties.getAuth().getUser().getTokenHeader(),
                               BaseThreadLocalHandler.getToken())
                        .header(securityProperties.getAuth().getClient().getTokenHeader(),
                                securityAuthClientConfig.getClientToken())
                        .build();
        Response response = chain.proceed(request);

        if(HttpStatus.FORBIDDEN.value() == response.code()){
            //可能是token过去，刷新token重新请求
            if (response.body().string().contains(String.valueOf(BaseThreadLocalConstants.EX_CLIENT_INVALID_CODE))) {
                securityAuthClientConfig.refreshClientToken();
                request = chain.request()
                        .newBuilder()
                        .header(securityProperties.getAuth().getUser().getTokenHeader(),
                                BaseThreadLocalHandler.getToken())
                        .header(securityProperties.getAuth().getClient().getTokenHeader(),
                                securityAuthClientConfig.getClientToken())

                        .build();
                response = chain.proceed(request);
            }
        }
        return response;
    }
}
