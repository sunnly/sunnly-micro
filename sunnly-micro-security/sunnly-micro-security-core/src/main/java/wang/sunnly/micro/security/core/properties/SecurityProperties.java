package wang.sunnly.micro.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Sunnly
 * @ClassName SunnlySecurityProperties
 * @Date 2019/6/12 0012 21:40
 **/
@Component
@ConfigurationProperties(prefix = "sunnly.security")
public class SecurityProperties {

    private SecurityAuthProperties auth = new SecurityAuthProperties();

    public SecurityAuthProperties getAuth() {
        return auth;
    }

    public void setAuth(SecurityAuthProperties auth) {
        this.auth = auth;
    }
}
