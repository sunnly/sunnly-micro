package wang.sunnly.micro.module.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import wang.sunnly.micro.module.demo.consumer.service.impl.FeignUserServiceFallback;

/**
 * @author Sunnly
 * @ClassName FeignUserService
 * @Date 2019/6/18 12:52
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-module-demo-producer", fallback = FeignUserServiceFallback.class)
public interface FeignUserService {

    @GetMapping("/intercept/user/test1")
    public String test1();

    @GetMapping("/intercept/user/test2")
    public String test2();

    @GetMapping("/intercept/user/pass")
    public String test3();
}
