package wang.sunnly.micro.security.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import wang.sunnly.micro.security.client.service.impl.SecurityAuthUserFeignFallback;

/**
 * @author Sunnly
 * @ClassName SecutiryAuthUserService
 * @Date 2019/6/16 0016 23:31
 **/
@FeignClient(value = "${sunnly.security.auth.service-id}", fallback = SecurityAuthUserFeignFallback.class)
public interface SecurityAuthUserFeign {

}
