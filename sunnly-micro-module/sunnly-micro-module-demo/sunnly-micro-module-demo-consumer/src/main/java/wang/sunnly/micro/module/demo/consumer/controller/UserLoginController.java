package wang.sunnly.micro.module.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.demo.consumer.service.UserLoginService;
import wang.sunnly.micro.security.client.annotation.IgnoreUserToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sunnly
 * @ClassName UserLoginController
 * @Date 2019/6/18 13:30
 * @Version 1.0
 */
@RestController
public class UserLoginController {

    @Autowired
    UserLoginService userLoginService;

    @IgnoreUserToken
    @GetMapping("/login")
    public ObjectRestResponse<String> login(@RequestParam("username") String username,
                                            @RequestParam("password")  String password,
                                            HttpServletRequest request,
                                            HttpServletResponse response){
        ObjectRestResponse<String> res = userLoginService.getToken(new JWTAuthenticationUser(username, password));
        if (res.getStatus() == HttpStatus.OK.value()){
            String token = res.getData();
            boolean verify = userLoginService.verify(token.replace("1","2"));

//            userLoginService.refreshToken();
        }

        return res;
    }
    @GetMapping("/re")
    public String refreshToken(@RequestParam("username") String username,
                                            @RequestParam("password")  String password,
                                            HttpServletRequest request,
                                            HttpServletResponse response){
        userLoginService.refreshToken();
        return "success";
    }



}
