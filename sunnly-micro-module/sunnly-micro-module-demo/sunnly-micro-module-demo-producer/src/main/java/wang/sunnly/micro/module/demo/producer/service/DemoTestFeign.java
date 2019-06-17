package wang.sunnly.micro.module.demo.producer.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.demo.producer.service.impl.DemoTestFeignFallback;

/**
 * @author Sunnly
 * @ClassName TestFeign
 * @Date 2019/6/17 0017 0:01
 **/
@FeignClient(value = "sunnly-micro-security-oauth", fallback = DemoTestFeignFallback.class)
public interface DemoTestFeign {
    @PostMapping("/client/servicePubKey")
    public ObjectRestResponse getServicePubKey(@RequestParam("clientId") String clientId, @RequestParam("secret")  String secret);



}
