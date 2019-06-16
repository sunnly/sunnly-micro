package wang.sunnly.micro.tools.validate.properties;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Sunnly
 * @ClassName ValidateCodeProperties
 * @Date 2019/6/10 0010 20:30
 **/
@Component
@ConfigurationProperties(prefix = "sunnly.validate.code")
public class ValidateCodeProperties extends SecurityProperties {

    ValidateImageProperties image = new ValidateImageProperties();

    ValidateProperties sms = new ValidateProperties();

    ValidateProperties mail = new ValidateProperties();

    public ValidateImageProperties getImage() {
        return image;
    }

    public void setImage(ValidateImageProperties image) {
        this.image = image;
    }

    public ValidateProperties getSms() {
        return sms;
    }

    public void setSms(ValidateProperties sms) {
        this.sms = sms;
    }

    public ValidateProperties getMail() {
        return mail;
    }

    public void setMail(ValidateProperties mail) {
        this.mail = mail;
    }
}
