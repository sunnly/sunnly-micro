package wang.sunnly.micro.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Sunnly
 * @ClassName OauthApplication
 * @Date 2019/6/15 0015 21:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("wang.sunnly.micro.security.oauth.mapper")
@ComponentScan("wang.sunnly.micro")
@EnableFeignClients
public class SecurityOauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityOauthApplication.class, args);
    }
}
