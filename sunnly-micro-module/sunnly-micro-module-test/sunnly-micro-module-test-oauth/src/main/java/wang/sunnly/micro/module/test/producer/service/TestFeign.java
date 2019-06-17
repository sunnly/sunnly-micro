package wang.sunnly.micro.module.test.producer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.test.producer.service.impl.TestFeignFallback;

/**
 * @author Sunnly
 * @ClassName TestFegin
 * @Date 2019/6/17 9:45
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-security-oauth", fallback = TestFeignFallback.class)
public interface TestFeign {

    @GetMapping("/client/myClient")
    public ObjectRestResponse getAllowClient(@RequestParam("clientId") String clientId, @RequestParam("secret")  String secret);

    @PostMapping("/client/token")
    public ObjectRestResponse<String> getAccessToken(@RequestParam("clientId") String clientId,@RequestParam("secret")  String secret);

    @PostMapping("/client/servicePubKey")
    public ObjectRestResponse getServicePubKey(@RequestParam("clientId") String clientId,@RequestParam("secret")  String secret);

    @PostMapping("/client/userPubKey")
    public ObjectRestResponse getUserPubKey(@RequestParam("clientId") String clientId,@RequestParam("secret")  String secret);

    @GetMapping("/client/validate")
    public boolean validateClientIdAndSecret(@RequestParam("clientId") String clientId,@RequestParam("secret")  String secret);

    }
