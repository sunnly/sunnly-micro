package wang.sunnly.micro.module.admin.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Sunnly
 * @ClassName AdminProducerApplication
 * @Date 2019/6/16 0016 0:56
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("wang.sunnly.micro.module.admin.producer.mapper")
public class AdminProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminProducerApplication.class, args);
    }
}
