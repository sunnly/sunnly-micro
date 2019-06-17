package wang.sunnly.micro.module.demo.producer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.module.demo.producer.service.DemoTestFeign;

/**
 * @author Sunnly
 * @ClassName TestFeignFallback
 * @Date 2019/6/17 0017 0:02
 **/
@Component
public class DemoTestFeignFallback implements DemoTestFeign {


    @Override
    public ObjectRestResponse getServicePubKey(String clientId, String secret) {
        return new ObjectRestResponse().data("error");
    }
}
