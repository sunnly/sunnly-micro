package wang.sunnly.micro.security.client.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.service.TestFeign;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

/**
 * @author Sunnly
 * @ClassName TestFeignFallback
 * @Date 2019/6/17 0017 0:02
 **/
@Component
public class TestFeignFallback implements TestFeign {
//    @Override
//    public ObjectRestResponse getAllowClient(String clientId, String secret) throws Exception {
//        throw new SecurityTokenException(SecurityStatus.CLIENT_OR_SECRENT_ERROR);
//    }
@Override
public String getUserById(String id) {
    throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
}
}
