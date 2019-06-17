package wang.sunnly.micro.security.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import wang.sunnly.micro.security.client.interceptor.ClientAuthInterceptor;
import wang.sunnly.micro.security.client.interceptor.UserAuthRestInterceptor;

/**
 * @author Sunnly
 * @ClassName WebConfiguration
 * @Date 2019/6/16 0016 21:26
 **/
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(clientAuthInterceptor());
        registry.addInterceptor(userAuthRestInterceptor());
    }

    @Bean
    ClientAuthInterceptor clientAuthInterceptor(){
        return new ClientAuthInterceptor();
    }
    @Bean
    UserAuthRestInterceptor userAuthRestInterceptor(){
        return new UserAuthRestInterceptor();
    }
}
