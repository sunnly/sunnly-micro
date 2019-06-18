package wang.sunnly.micro.security.oauth.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import wang.sunnly.micro.security.oauth.interceptor.ClientTokenInterceptor;

/**
 * @author Sunnly
 * @ClassName FeignConfiguration
 * @Date 2019/6/18 14:30
 * @Version 1.0
 */
@Configurable
public class FeignConfiguration {

    @Bean
    public ClientTokenInterceptor clientTokenInterceptor(){
        return new ClientTokenInterceptor();
    }



}
