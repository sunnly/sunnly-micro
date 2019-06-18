package wang.sunnly.micro.security.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.oauth.service.AuthUserService;

/**
 * @author Sunnly
 * @ClassName AuthUserController
 * @Date 2019/6/18 13:41
 * @Version 1.0
 */
@RestController
@RequestMapping("jwt")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    public ObjectRestResponse<String> getToken(@RequestBody JWTAuthenticationUser user){
        String token = authUserService.getToken(user);
        return new ObjectRestResponse<String>();
    }
}
