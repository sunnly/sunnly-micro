package wang.sunnly.micro.security.client.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.service.SecurityAuthClientFeign;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

/**
 * @author Sunnly
 * @ClassName SecurityAuthServiceFeignFallback
 * @Date 2019/6/16 0016 23:38
 **/
@Component
public class SecurityAuthClientFeignFallback implements SecurityAuthClientFeign {
    @Override
    public ObjectRestResponse getAccessToken(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse getAllowClient(String clientId, String secret) {
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
