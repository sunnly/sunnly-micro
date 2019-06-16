package wang.sunnly.micro.module.test.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Sunnly
 * @ClassName TestConsumerApplication
 * @Date 2019/6/16 0016 10:58
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TestConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestConsumerApplication.class, args);
    }
}
