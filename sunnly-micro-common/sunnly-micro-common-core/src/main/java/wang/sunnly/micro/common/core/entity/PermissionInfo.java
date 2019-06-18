package wang.sunnly.micro.common.core.entity;

import java.io.Serializable;

/**
 * @author Sunnly
 * @ClassName PermissionInfo
 * @Date 2019/6/18 15:13
 * @Version 1.0
 */
public class PermissionInfo implements Serializable {

    private String code;
    private String type;
    private String uri;
    private String method;
    private String name;
    private String menu;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
