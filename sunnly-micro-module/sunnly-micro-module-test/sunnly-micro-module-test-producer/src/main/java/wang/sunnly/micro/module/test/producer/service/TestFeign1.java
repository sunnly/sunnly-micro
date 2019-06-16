package wang.sunnly.micro.module.test.producer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wang.sunnly.micro.module.test.producer.service.impl.TestFeign1Fallback;

/**
 * @author Sunnly
 * @ClassName TestFeign
 * @Date 2019/6/17 0017 0:01
 **/
@FeignClient(value = "sunnly-micro-module-admin-producer", fallback = TestFeign1Fallback.class)
public interface TestFeign1 {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id);
}
