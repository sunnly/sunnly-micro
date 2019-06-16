package wang.sunnly.micro.module.admin.consumer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.module.admin.consumer.service.UserService;

/**
 * @author Sunnly
 * @ClassName UserServiceFallback
 * @Date 2019/5/31 0031 21:57
 **/
@Component
public class UserServiceFallback implements UserService {
    @Override
    public String get(String id) {
        return "UserService FallBack";
    }
}
