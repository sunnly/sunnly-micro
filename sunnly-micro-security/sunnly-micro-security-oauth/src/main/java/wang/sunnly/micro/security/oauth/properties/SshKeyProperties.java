package wang.sunnly.micro.security.oauth.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Sunnly
 * @ClassName PubPriKeyProperties
 * @Date 2019/6/12 0012 23:32
 **/
@Data
@Configurable
@Component
public class SshKeyProperties {

    @Value("sunnly.security.auth.user.rsa-secret")
    private String userSecret;
    @Value("sunnly.security.auth.client.rsa-secret")
    private String serviceSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
}
