package wang.sunnly.micro.module.demo.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
import wang.sunnly.micro.module.demo.producer.entity.TbUser;

/**
 * @author Sunnly
 * @ClassName AdminProducerApplication
 * @Date 2019/6/17 12:23
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("wang.sunnly.micro.module.demo.producer.mapper")
@EnableFeignClients(basePackages = {"wang.sunnly.micro"})
@ComponentScans({
        @ComponentScan("wang.sunnly.micro.security"),
        @ComponentScan("wang.sunnly.micro.common.web")
})
//@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "wang.sunnly.**.component"))
public class DemoProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoProducerApplication.class,args);
    }
}
