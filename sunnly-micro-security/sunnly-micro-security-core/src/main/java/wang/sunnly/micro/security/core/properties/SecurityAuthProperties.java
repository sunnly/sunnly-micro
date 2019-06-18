package wang.sunnly.micro.security.core.properties;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Sunnly
 * @ClassName SecurityAuthProperties
 * @Date 2019/6/12 0012 21:42
 **/
public class SecurityAuthProperties {

    //鉴权服务端ID
    private String serviceId = "sunnly-auth";
    private SecurityUserProperties user = new SecurityUserProperties();
    private SecurityClientProperties client = new SecurityClientProperties();

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public SecurityUserProperties getUser() {
        return user;
    }

    public void setUser(SecurityUserProperties user) {
        this.user = user;
    }

    public SecurityClientProperties getClient() {
        return client;
    }

    public void setClient(SecurityClientProperties client) {
        this.client = client;
    }
}
