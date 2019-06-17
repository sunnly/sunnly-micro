package wang.sunnly.micro.module.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.module.demo.consumer.service.ConsumerDemoFeign;

/**
 * @author Sunnly
 * @ClassName ConsumerDemoController
 * @Date 2019/6/17 0017 22:11
 **/
@RestController
@RequestMapping("consumer")
public class ConsumerDemoController {

    @Autowired
    private ConsumerDemoFeign consumerDemoFeign;

    @GetMapping
    public String getTest(){
        String tb = consumerDemoFeign.tb();
        return tb;
    }
}
