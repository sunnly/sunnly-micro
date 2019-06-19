package wang.sunnly.micro.common.core.entity;

import java.io.Serializable;

/**
 * @author Sunnly
 * @ClassName JWTUser
 * @Date 2019/6/18 13:48
 * @Version 1.0
 */
public class JWTAuthenticationUser implements Serializable {

    private static final long serialVersionUID = -6546165146493203065L;
    private String username;
    private String password;

    public JWTAuthenticationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public JWTAuthenticationUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
