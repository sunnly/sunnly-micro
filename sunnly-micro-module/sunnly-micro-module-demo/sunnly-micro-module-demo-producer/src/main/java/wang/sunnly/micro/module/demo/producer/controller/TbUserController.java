package wang.sunnly.micro.module.demo.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.common.web.msg.TableResultResponse;
import wang.sunnly.micro.module.demo.producer.entity.TbUser;
import wang.sunnly.micro.module.demo.producer.service.TbUserService;
import wang.sunnly.micro.module.demo.producer.service.DemoTestFeign;
import wang.sunnly.micro.tools.mysql.controller.BaseController;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName TbUserController
 * @Date 2019/6/17 12:31
 * @Version 1.0
 */
@RestController
@RequestMapping("demo")
public class TbUserController extends BaseController<TbUserService, TbUser> {

    @Autowired
    private DemoTestFeign demoTestFeign;
    @GetMapping("/tb")
    public TableResultResponse tb (){
        List list = service.selectListAll();
        return new TableResultResponse(service.selectCount(),list);
    }

    @GetMapping("/ob")
    public ObjectRestResponse ob(){
        return demoTestFeign.getServicePubKey("ace-admin","123456");
    }

    @GetMapping("token")
    public String getToken(){

        return null;
    }
}
