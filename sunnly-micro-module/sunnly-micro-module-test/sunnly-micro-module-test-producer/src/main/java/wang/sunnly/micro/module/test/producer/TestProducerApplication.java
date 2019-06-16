package wang.sunnly.micro.module.test.producer;

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
 * @ClassName TestProducerApplication
 * @Date 2019/6/16 0016 11:27
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("wang.sunnly.micro.module.test.producer.mapper")
@ComponentScans({
   @ComponentScan("wang.sunnly.micro.common.web.config"),
   @ComponentScan("wang.sunnly.micro")
})
@EnableFeignClients
public class TestProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestProducerApplication.class, args);
    }
}
