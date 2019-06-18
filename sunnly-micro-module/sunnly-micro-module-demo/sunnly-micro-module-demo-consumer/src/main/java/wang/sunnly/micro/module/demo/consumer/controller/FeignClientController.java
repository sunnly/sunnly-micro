package wang.sunnly.micro.module.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.module.demo.consumer.service.FeignClientService;

/**
 * 服务鉴权拦截器测试 /intercept/** 进行拦截
 * @author Sunnly
 * @ClassName InterceptFeign
 * @Date 2019/6/18 9:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "feign/client" ,produces = {"application/json;charset=UTF-8"})
public class FeignClientController {

    @Autowired
    private FeignClientService feignClientService;

    @GetMapping(value = "/test1")
    public String test1(){

        return feignClientService.test1();
    }
    @GetMapping(value = "/test2")
    public String test2(){
        return feignClientService.test2();
    }
    @GetMapping(value = "/pass")
    public String test3(){
        return feignClientService.test3();
    }
}
