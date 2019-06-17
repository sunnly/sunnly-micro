package wang.sunnly.micro.module.test.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.test.producer.service.TestFeign;

/**
 * @author Sunnly
 * @ClassName TestOauthController
 * @Date 2019/6/17 9:40
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestOauthController {


    @Autowired
    private TestFeign testFeign;

    @GetMapping
    public ObjectRestResponse get(){
//        ObjectRestResponse allowClient = testFeign.getAllowClient("ace-admin", "123456");
        ObjectRestResponse servicePubKey = testFeign.getServicePubKey("ace-admin", "123456");
        return servicePubKey;
    }
}
