package wang.sunnly.micro.security.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wang.sunnly.micro.security.client.service.impl.TestFeignFallback;

/**
 * @author Sunnly
 * @ClassName TestFeign
 * @Date 2019/6/17 0017 0:01
 **/
//@FeignClient(value = "sunnly-micro-security-oauth", fallback = TestFeignFallback.class)
@FeignClient(value = "sunnly-micro-module-admin-producer", fallback = TestFeignFallback.class)
public interface TestFeign {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id);

//    @GetMapping("/client/myClient")
//    public ObjectRestResponse getAllowClient(String clientId, String secret) throws Exception;
}
