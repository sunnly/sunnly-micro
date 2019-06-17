package wang.sunnly.micro.module.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import wang.sunnly.micro.module.demo.consumer.service.impl.ConsumerDemoFeignFallback;

/**
 * @author Sunnly
 * @ClassName ConsumerDemoFeign
 * @Date 2019/6/17 0017 22:14
 **/
@FeignClient(value = "sunnly-micro-module-demo-producer", fallback = ConsumerDemoFeignFallback.class)
public interface ConsumerDemoFeign {

    @GetMapping("/demo/tb")
    public String tb ();
}
