package wang.sunnly.micro.security.oauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import wang.sunnly.micro.common.core.entity.UserInfo;
import wang.sunnly.micro.security.oauth.configuration.FeignConfiguration;

/**
 * @author Sunnly
 * @ClassName AuthUserFeign
 * @Date 2019/6/18 14:00
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-module-admin-consumer",
        configuration = FeignConfiguration.class)
public class AuthUserFeign {

//    public UserInfo v();
}
