package wang.sunnly.micro.common.core.entity;

import java.io.Serializable;

/**
 * @author Sunnly
 * @ClassName UserInfo
 * @Date 2019/6/18 15:05
 * @Version 1.0
 */
public class UserInfo implements Serializable {

    public String id;
    public String username;
    public String password;
    public String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
