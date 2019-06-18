package wang.sunnly.micro.security.client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import wang.sunnly.micro.security.client.interceptor.ClientAuthInterceptor;
import wang.sunnly.micro.security.client.interceptor.UserAuthRestInterceptor;
import wang.sunnly.micro.security.client.properties.PathFilterProperties;

/**
 * @author Sunnly
 * @ClassName WebConfiguration
 * @Date 2019/6/16 0016 21:26
 **/
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

//    @Value("#{'${sunnly.feign.intercept-path:}'.split(',')}")
//    private List<String> includePathPatterns;

    @Autowired
    private PathFilterProperties pathFilterProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(clientAuthInterceptor())
            .addPathPatterns(pathFilterProperties.getClient().getIntercept())
            .excludePathPatterns(pathFilterProperties.getClient().getExclude());
        registry.addInterceptor(userAuthRestInterceptor())
            .addPathPatterns(pathFilterProperties.getUser().getIntercept())
            .excludePathPatterns(pathFilterProperties.getUser().getExclude());

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
