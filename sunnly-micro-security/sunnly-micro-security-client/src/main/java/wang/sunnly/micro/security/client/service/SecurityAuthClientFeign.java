package wang.sunnly.micro.security.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.service.impl.SecurityAuthClientFeignFallback;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName SecurityAuthServiceService
 * @Date 2019/6/16 0016 23:31
 **/
@FeignClient(value = "${sunnly.security.auth.service-id}"
//        fallback = SecurityAuthClientFeignFallback.class
)
public interface SecurityAuthClientFeign {
    @PostMapping("/client/token")
    ObjectRestResponse<String> getAccessToken(@RequestParam("clientId") String clientId,
                                      @RequestParam("secret") String secret);

    @GetMapping("/client/myClient")
    public ObjectRestResponse<List<String>> getAllowClient(@RequestParam("clientId") String clientId,
                                                           @RequestParam("secret") String secret);

    @PostMapping("/client/servicePubKey")
    public ObjectRestResponse<byte[]> getServicePubKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

    @PostMapping("/client/userPubKey")
    public ObjectRestResponse<byte[]> getUserPubKey(@RequestParam("clientId") String clientId,
                                            @RequestParam("secret") String secret);

    @GetMapping("/client/validate")
    public boolean validateClientIdAndSecret(@RequestParam("clientId") String clientId,
                                             @RequestParam("secret") String secret);
}
