package wang.sunnly.micro.security.core.exception;

import wang.sunnly.micro.common.core.exception.BaseException;
import wang.sunnly.micro.security.core.status.SecurityStatus;

/**
 * 自定义异常
 * @author Sunnly
 * @ClassName SecurityTokenException
 * @Date 2019/6/13 15:51
 * @Version 1.0
 */
public class SecurityTokenException extends BaseException {

    public SecurityTokenException(SecurityStatus ex){
        super(ex.reasonPhrase(),ex.value());
    }

}
