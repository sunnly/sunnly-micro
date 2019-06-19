package wang.sunnly.micro.security.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.core.exception.UserInvalidException;
import wang.sunnly.micro.common.core.status.UserInvalidStatus;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.oauth.service.AuthUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户token获取、刷新、验证
 *
 * @Author Sunnly
 * @create 2019年6月19日 11:13:16
 **/
@RestController
@RequestMapping("jwt")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @Value("${sunnly.security.auth.user.token-header:Authorization}")
    private String tokenHeader;

    /**
     * 获取token
     * @Author Sunnly
     * @create 2019年6月19日 10:58:17
     **/
    @PostMapping("/token")
    public ObjectRestResponse<String> getToken(@RequestBody JWTAuthenticationUser user) throws Exception {
        String token = authUserService.getToken(user);
        return new ObjectRestResponse<String>().data(token);
    }

    /**
     * 刷新token
     *
     * @Author Sunnly
     * @create 2019年6月19日 11:05:33
     **/
    @PostMapping("/refresh")
    public ObjectRestResponse<String> refreshToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(tokenHeader);
        String refreshToken =authUserService.refeshToken(token);
        return new ObjectRestResponse<String>().data(refreshToken);
    }

    /**
     * 验证token
     *
     * @Author Sunnly
     * @create 2019年6月19日 11:05:52
     **/
    @GetMapping("/verify")
    public boolean verify(@RequestParam("token") String token) throws Exception{

        authUserService.validate(token);
        return true;

    }
    
}
