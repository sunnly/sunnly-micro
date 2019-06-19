package wang.sunnly.micro.module.demo.consumer.service.impl;

import org.springframework.stereotype.Service;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.core.exception.UserInvalidException;
import wang.sunnly.micro.common.core.status.UserInvalidStatus;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.demo.consumer.service.UserLoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * UserLoginServiceFallback
 *
 * @author Sunnly
 * @create 2019/6/19 11:20
 */
@Service
public class UserLoginServiceFallback implements UserLoginService {
    @Override
    public ObjectRestResponse<String> getToken(JWTAuthenticationUser user) {
        throw new UserInvalidException(UserInvalidStatus.NEWWORK_ERROR);
    }

    @Override
    public ObjectRestResponse<String> refreshToken() {
        throw new UserInvalidException(UserInvalidStatus.NEWWORK_ERROR);
    }

    @Override
    public boolean verify(String token) {
        throw new UserInvalidException(UserInvalidStatus.NEWWORK_ERROR);
    }
}
