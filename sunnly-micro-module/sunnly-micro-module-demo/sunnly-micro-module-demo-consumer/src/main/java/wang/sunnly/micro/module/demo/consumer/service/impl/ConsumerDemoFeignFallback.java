package wang.sunnly.micro.module.demo.consumer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.module.demo.consumer.service.ConsumerDemoFeign;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

/**
 * @author Sunnly
 * @ClassName ConsumerDemoFeignFallback
 * @Date 2019/6/17 0017 22:16
 **/
@Component
public class ConsumerDemoFeignFallback implements ConsumerDemoFeign {
    @Override
    public String tb() {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }
}
