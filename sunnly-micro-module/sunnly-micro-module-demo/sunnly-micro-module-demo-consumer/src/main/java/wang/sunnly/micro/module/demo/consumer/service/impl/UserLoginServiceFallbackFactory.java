package wang.sunnly.micro.module.demo.consumer.service.impl;

import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.core.exception.UserInvalidException;
import wang.sunnly.micro.common.core.status.UserInvalidStatus;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.demo.consumer.service.UserLoginService;

/**
 * @author Sunnly
 * @ClassName UserLoginServiceFallbackFactory
 * @Date 2019/6/19 0019 20:34
 **/
@Service
public class UserLoginServiceFallbackFactory implements FallbackFactory<UserLoginService> {
    @Override
    public UserLoginService create(Throwable cause) {

        String msg = cause == null ? "" : cause.getMessage();
        if (StringUtils.isNotEmpty(msg)) {
            throw new UserInvalidException(cause.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new UserLoginService() {

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
        };
    }
}
