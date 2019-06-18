package wang.sunnly.micro.module.demo.producer.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务鉴权拦截器测试 /intercept/** 进行拦截
 * @author Sunnly
 * @ClassName InterceptFeign
 * @Date 2019/6/18 9:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "intercept/client" ,produces = {"application/json;charset=UTF-8"})
public class InterceptClientController {


    @GetMapping(value = "/test1")
    public String test1(){

        return "贱民乃服务器王国子民test1，接受王的检验, 请问我可以通过吗？";
    }
    @GetMapping(value = "/test2")
    public String test2(){
        return "民女乃服务器王国子民test2，接受王的检验, 请问我可以通过吗？";
    }
    @GetMapping(value = "/pass")
    public String test3(){
        return "大爷我吕布在世，谁能拦我";
    }
}
