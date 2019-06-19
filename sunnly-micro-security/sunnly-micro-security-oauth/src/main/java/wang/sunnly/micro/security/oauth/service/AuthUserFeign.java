package wang.sunnly.micro.security.oauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import wang.sunnly.micro.common.core.entity.UserInfo;
import wang.sunnly.micro.security.oauth.configuration.FeignConfiguration;

import java.util.Map;

/**
 * @author Sunnly
 * @ClassName AuthUserFeign
 * @Date 2019/6/18 14:00
 * @Version 1.0
 */
@FeignClient(value = "sunnly-micro-module-admin-producer",
        configuration = FeignConfiguration.class)
public interface AuthUserFeign {

    @PostMapping("/api/user/validate")
    public @ResponseBody UserInfo validate(@RequestBody Map<String,String> body);

}
//    context additional