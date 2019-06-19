package wang.sunnly.micro.common.core.exception;

import wang.sunnly.micro.common.core.status.UserInvalidStatus;

/**
 * UserException
 *
 * @author Sunnly
 * @create 2019/6/19 10:45
 */
public class UserInvalidException extends BaseException {
    public UserInvalidException(UserInvalidStatus status) {
        super(status.reasonPhrase(), status.value());
    }
}
