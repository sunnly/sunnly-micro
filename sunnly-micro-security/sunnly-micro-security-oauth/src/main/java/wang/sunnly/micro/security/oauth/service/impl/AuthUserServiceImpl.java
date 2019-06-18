package wang.sunnly.micro.security.oauth.service.impl;

import org.springframework.stereotype.Service;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.security.oauth.service.AuthUserService;

/**
 * @author Sunnly
 * @ClassName AuthUserServiceImpl
 * @Date 2019/6/18 13:56
 * @Version 1.0
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Override
    public String getToken(JWTAuthenticationUser user) {
        
        return null;
    }
}
