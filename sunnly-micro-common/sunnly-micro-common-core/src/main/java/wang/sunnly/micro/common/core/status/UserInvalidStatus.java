package wang.sunnly.micro.common.core.status;

/**
 * @author Sunnly
 * @ClassName SercutityExceptionConstants
 * @Date 2019/6/13 16:06
 * @Version 1.0
 */
public enum UserInvalidStatus {

    USER_PASS_INVALID_CODE(40001,"用户名或密码错误"),
    USER_VALIDATE_ERR(40002,"验证失败"),
    USER_TOKEN_ERR(40003,"用户名或密码错误"),
    USER_TOKEN_INVALID_ERR(40004,"用户名或密码错误"),



    NEWWORK_ERROR(41001,"网络异常")
    ;


    private int value;
    private String reasonPhrase;

    private UserInvalidStatus(int value, String reasonPhrase) {
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
        for (UserInvalidStatus s : UserInvalidStatus.values()){
            if (code == s.value)
                return s.reasonPhrase();
        }
        return null;
    }

}
