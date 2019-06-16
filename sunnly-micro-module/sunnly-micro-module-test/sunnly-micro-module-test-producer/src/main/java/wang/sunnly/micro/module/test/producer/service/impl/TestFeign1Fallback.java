package wang.sunnly.micro.module.test.producer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.module.test.producer.service.TestFeign1;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

/**
 * @author Sunnly
 * @ClassName TestFeignFallback
 * @Date 2019/6/17 0017 0:02
 **/
@Component
public class TestFeign1Fallback implements TestFeign1 {

    @Override
    public String getUserById(String id) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }
}
