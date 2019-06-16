package wang.sunnly.micro.module.admin.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Sunnly
 * @ClassName AdminConsumerApplication
 * @Date 2019/6/16 0016 1:37
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AdminConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminConsumerApplication.class, args);
    }
}
