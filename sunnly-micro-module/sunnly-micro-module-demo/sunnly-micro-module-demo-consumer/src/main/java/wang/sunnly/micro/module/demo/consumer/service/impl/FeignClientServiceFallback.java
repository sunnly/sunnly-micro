package wang.sunnly.micro.module.demo.consumer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.module.demo.consumer.service.FeignClientService;

/**
 * @author Sunnly
 * @ClassName FeignClientServiceFallback
 * @Date 2019/6/18 12:53
 * @Version 1.0
 */
@Component
public class FeignClientServiceFallback implements FeignClientService {
    @Override
    public String test1() {
        return "网络异常啦";
    }

    @Override
    public String test2() {
        return "网络异常啦";
    }

    @Override
    public String test3() {
        return "网络异常啦";
    }
}
