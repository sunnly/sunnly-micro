package wang.sunnly.micro.module.demo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Sunnly
 * @ClassName DemoConsumerApplication
 * @Date 2019/6/17 0017 21:46
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("wang.sunnly.micro.module.demo.consumer.mapper")
@EnableFeignClients(basePackages = {"wang.sunnly.micro"})
@ComponentScans({
        @ComponentScan("wang.sunnly.micro.security.client"),
        @ComponentScan("wang.sunnly.micro.common.web")
})
public class DemoConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoConsumerApplication.class, args);
    }
}
