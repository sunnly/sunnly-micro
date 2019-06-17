package wang.sunnly.micro.module.test.producer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.test.producer.service.TestFeign;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

/**
 * @author Sunnly
 * @ClassName TestFeignFallback
 * @Date 2019/6/17 9:47
 * @Version 1.0
 */
@Component
public class TestFeignFallback implements TestFeign {

    @Override
    public ObjectRestResponse getAllowClient(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse<String> getAccessToken(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse getServicePubKey(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse getUserPubKey(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public boolean validateClientIdAndSecret(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }
}
