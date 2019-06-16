package wang.sunnly.micro.security.client.properties;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Sunnly
 * @ClassName SecurityClientProperties
 * @Date 2019/6/12 0012 21:49
 **/
public class SecurityClientProperties {

    private String id;
    private String secret;
    private String tokenHeader;

    private byte[] pubKeyByte;
    @Value("${spring.application.name}")
    private String applicationName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        this.tokenHeader = tokenHeader;
    }

    public byte[] getPubKeyByte() {
        return pubKeyByte;
    }

    public void setPubKeyByte(byte[] pubKeyByte) {
        this.pubKeyByte = pubKeyByte;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
