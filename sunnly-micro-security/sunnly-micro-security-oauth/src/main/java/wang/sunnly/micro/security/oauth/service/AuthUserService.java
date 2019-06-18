package wang.sunnly.micro.security.oauth.service;

import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;

/**
 * @author Sunnly
 * @ClassName AuthUserService
 * @Date 2019/6/18 13:54
 * @Version 1.0
 */
public interface AuthUserService {

    public String getToken(JWTAuthenticationUser user);
}
