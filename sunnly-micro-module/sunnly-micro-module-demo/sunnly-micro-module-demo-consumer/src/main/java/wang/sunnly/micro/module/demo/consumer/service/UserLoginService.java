package wang.sunnly.micro.module.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.module.demo.consumer.service.impl.FeignUserServiceFallback;

/**
 * @author Sunnly
 * @ClassName UserLoginService
 * @Date 2019/6/18 13:34
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-security-oauth", fallback = FeignUserServiceFallback.class)
public interface UserLoginService {
    public String login(JWTAuthenticationUser user);
}
