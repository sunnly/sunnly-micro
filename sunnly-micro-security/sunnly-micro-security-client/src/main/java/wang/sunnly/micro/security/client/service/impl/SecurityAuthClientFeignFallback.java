package wang.sunnly.micro.security.client.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.service.SecurityAuthClientFeign;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName SecurityAuthServiceFeignFallback
 * @Date 2019/6/16 0016 23:38
 **/
@Component
public class SecurityAuthClientFeignFallback implements SecurityAuthClientFeign {
    @Override
    public ObjectRestResponse<String> getAccessToken(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse<List<String>> getAllowClient(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse<byte[]> getServicePubKey(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public ObjectRestResponse<byte[]> getUserPubKey(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }

    @Override
    public boolean validateClientIdAndSecret(String clientId, String secret) {
        throw new SecurityTokenException(SecurityStatus.NETWORK_CONNECTION_ERR);
    }
}
