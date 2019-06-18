package wang.sunnly.micro.module.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.module.demo.consumer.service.FeignUserService;

/**
 * 用户鉴权拦截器测试
 * @author Sunnly
 * @ClassName InterceptUser
 * @Date 2019/6/18 9:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "feign/user", produces = {"application/json;charset=UTF-8"})
public class FeignUserController {

    @Autowired
    private FeignUserService feignUserService;

    @GetMapping("/test1")
    public String test1(){
        return feignUserService.test1();
    }
    @GetMapping("/test2")
    public String test2(){
        return feignUserService.test2();
    }
    @GetMapping("/pass")
    public String test3(){
        return feignUserService.test3();
    }

}
