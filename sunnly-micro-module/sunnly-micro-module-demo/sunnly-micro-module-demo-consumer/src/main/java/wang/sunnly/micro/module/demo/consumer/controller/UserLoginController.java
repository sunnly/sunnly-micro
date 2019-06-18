package wang.sunnly.micro.module.demo.consumer.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.module.demo.consumer.service.UserLoginService;

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

    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")  String password){
//        userLoginService.login(username,password);
        return "success";
    }

}
