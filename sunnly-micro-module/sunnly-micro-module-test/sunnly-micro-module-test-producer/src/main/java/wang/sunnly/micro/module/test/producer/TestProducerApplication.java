package wang.sunnly.micro.module.test.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Sunnly
 * @ClassName TestProducerApplication
 * @Date 2019/6/16 0016 11:27
 **/
//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableSwagger2
//@MapperScan("wang.sunnly.micro.module.test.producer.mapper")
//@ComponentScan("wang.sunnly.micro")
//@ComponentScans({
//   @ComponentScan("wang.sunnly.micro.common.web.config"),
//   @ComponentScan("wang.sunnly.micro.module.test")
//})
//@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("wang.sunnly.micro.module.admin.producer.mapper")
public class TestProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestProducerApplication.class, args);
    }
}
