package wang.sunnly.micro.module.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.demo.consumer.config.NotBreakerConfiguration;
import wang.sunnly.micro.module.demo.consumer.service.impl.UserLoginServiceFallback;
import wang.sunnly.micro.module.demo.consumer.service.impl.UserLoginServiceFallbackFactory;

/**
 * @author Sunnly
 * @ClassName UserLoginService
 * @Date 2019/6/18 13:34
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-security-oauth",
        fallbackFactory = UserLoginServiceFallbackFactory.class,
configuration = NotBreakerConfiguration.class
)
//        fallback = UserLoginServiceFallback.class)
public interface UserLoginService {

    @PostMapping("/jwt/token")
    public ObjectRestResponse<String> getToken(@RequestBody JWTAuthenticationUser user);

    @PostMapping("/jwt/refresh")
    public ObjectRestResponse<String> refreshToken();

    @GetMapping("/jwt/verify")
    public boolean verify(@RequestParam("token") String token);
}
