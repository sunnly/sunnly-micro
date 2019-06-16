package wang.sunnly.micro.security.core.utils.client;

import wang.sunnly.micro.security.core.utils.jwt.IJWTInfo;

/**
 * @author Sunnly
 * @ClassName ClientInfo
 * @Date 2019/6/14 0014 0:01
 **/
public class ClientInfo implements IJWTInfo {

    String id;
    String clientId;
    String name;

    public ClientInfo(String clientId, String name, String id) {
        this.clientId = clientId;
        this.name = name;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUniqueName() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
