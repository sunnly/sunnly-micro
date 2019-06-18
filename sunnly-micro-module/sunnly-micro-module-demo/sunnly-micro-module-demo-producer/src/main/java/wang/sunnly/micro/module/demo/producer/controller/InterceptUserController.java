package wang.sunnly.micro.module.demo.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户鉴权拦截器测试
 * @author Sunnly
 * @ClassName InterceptUser
 * @Date 2019/6/18 9:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "intercept/user", produces = {"application/json;charset=UTF-8"})
public class InterceptUserController {

    @GetMapping("/test1")
    public String test1(){
        return "贱民初来乍到，接受王的检验";
    }
    @GetMapping("/test2")
    public String test2(){
        return "民女初来京城，谁能收留";
    }
    @GetMapping("/pass")
    public String test3(){
        return "大爷京城一霸，谁阻挡";
    }

}
