package wang.sunnly.micro.security.client.properties;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Sunnly
 * @ClassName SecurityUserProperties
 * @Date 2019/6/12 0012 21:47
 **/
public class SecurityUserProperties {

    private String tokenHeader;

    private byte[] pubKeyByte;

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
}
