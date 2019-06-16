package wang.sunnly.micro.security.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.service.impl.SecurityAuthClientFeignFallback;

/**
 * @author Sunnly
 * @ClassName SecurityAuthServiceService
 * @Date 2019/6/16 0016 23:31
 **/
//@FeignClient(value = "${sunnly.security.auth.service-id}", fallback = SecurityAuthClientFeignFallback.class)
@FeignClient(value = "sunnly-micro-security-oauth", fallback = SecurityAuthClientFeignFallback.class)
public interface SecurityAuthClientFeign {
    @PostMapping("/client/token")
    ObjectRestResponse getAccessToken(@RequestParam("clientId") String clientId,
                                      @RequestParam("secret") String secret);

    @GetMapping("/client/myClient")
    public ObjectRestResponse getAllowClient(String clientId, String secret);

    @PostMapping("/client/servicePubKey")
    public ObjectRestResponse getServicePubKey(String clientId, String secret);

    @PostMapping("/client/userPubKey")
    public ObjectRestResponse getUserPubKey(String clientId, String secret);

    @GetMapping("/client/validate")
    public boolean validateClientIdAndSecret(String clientId, String secret);
}
