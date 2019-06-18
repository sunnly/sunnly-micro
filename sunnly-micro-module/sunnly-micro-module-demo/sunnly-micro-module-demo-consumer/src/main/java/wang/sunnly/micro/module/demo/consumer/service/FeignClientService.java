package wang.sunnly.micro.module.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import wang.sunnly.micro.module.demo.consumer.service.impl.FeignClientServiceFallback;

/**
 * @author Sunnly
 * @IntefaceName FeignClientService
 * @Date 2019/6/18 12:51
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-module-demo-producer", fallback = FeignClientServiceFallback.class)
public interface FeignClientService {

    @GetMapping(value = "/intercept/client/test1")
    public String test1();

    @GetMapping(value = "/intercept/client/test2")
    public String test2();

    @GetMapping(value = "/intercept/client/pass")
    public String test3();
}
