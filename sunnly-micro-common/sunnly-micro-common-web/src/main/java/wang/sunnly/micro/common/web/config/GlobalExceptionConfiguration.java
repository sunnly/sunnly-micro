package wang.sunnly.micro.common.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wang.sunnly.micro.common.web.handler.GlobalExceptionHandler;

/**
 * @author Sunnly
 * @ClassName GlobalExceptionConfiguration
 * @Date 2019/6/16 0016 14:14
 **/
@Configuration("gloableException")
public class GlobalExceptionConfiguration {

    @Bean
    GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
}
