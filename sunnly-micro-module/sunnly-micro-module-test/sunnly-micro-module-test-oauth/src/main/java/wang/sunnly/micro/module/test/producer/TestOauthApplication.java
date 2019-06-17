package wang.sunnly.micro.module.test.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Sunnly
 * @ClassName TestProducerApplication
 * @Date 2019/6/17 9:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("wang.sunnly.micro")
public class TestOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestOauthApplication.class, args);
    }
}
