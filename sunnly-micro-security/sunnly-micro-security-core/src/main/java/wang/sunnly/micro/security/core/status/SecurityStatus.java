package wang.sunnly.micro.security.core.status;

/**
 * @author Sunnly
 * @ClassName SercutityExceptionConstants
 * @Date 2019/6/13 16:06
 * @Version 1.0
 */
public enum SecurityStatus {

    //服务鉴权异常
    //配置类5030X
    TOKEN_HEADER_NOT_CONFIG(50001,"Please configure: sunnly.security.auth.client.token-header"),
    //Token验证失败 5031X
    TOKEN_EMPTY(50310,"Client token is null or empty!"),
    TOKEN_EXPIRED(50311,"Client token expired!"),
    TOKEN_SIGNATURE_ERROR(50312,"Client token signature error!"),

    CLIENT_OR_SECRENT_ERROR(50320,"Client not found or Client secret is error!"),
    CLIENT_FORBIDDEN(50321, "Client is Forbidden!"),

    NETWORK_CONNECTION_ERR(50330,"网络连接错误"),
    //用户鉴权异常
    //配置类5035X
    //Token不合法 5036X

    TOHER_ERROR(50002,"其他异常");

    private int value;
    private String reasonPhrase;

    private SecurityStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value(){
        return this.value;
    }

    public String reasonPhrase(){
        return this.reasonPhrase;
    }

    public static String reasonPhrase(int code){
        for (SecurityStatus s : SecurityStatus.values()){
            if (code == s.value)
                return s.reasonPhrase();
        }
        return null;
    }

}
