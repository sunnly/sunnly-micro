package wang.sunnly.micro.security.oauth.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import wang.sunnly.micro.security.core.properties.SecurityProperties;
import wang.sunnly.micro.security.oauth.service.AuthClientServices;

/**
 *
 * 封装Feign调用请求头,将服务鉴权信息封装到请求头
 * 次微服务中不引入security-client，故在这里进行封装
 * @author Sunnly
 * @ClassName ClientTokenInterceptor
 * @Date 2019/6/18 14:40
 * @Version 1.0
 */
public class ClientTokenInterceptor implements RequestInterceptor {

    @Autowired
    SecurityProperties securityProperties;

    @Autowired
    AuthClientServices authClientServices;
    @Override
    public void apply(RequestTemplate requestTemplate) {

        try {
            requestTemplate.header(securityProperties.getAuth().getClient().getTokenHeader(),
                    authClientServices.generateToken(securityProperties.getAuth().getClient().getId(),
                            securityProperties.getAuth().getClient().getSecret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
