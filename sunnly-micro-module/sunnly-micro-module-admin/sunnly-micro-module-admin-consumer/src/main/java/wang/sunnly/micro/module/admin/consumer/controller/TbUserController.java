package wang.sunnly.micro.module.admin.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.module.admin.consumer.service.TbUserService;

import javax.annotation.Resource;

/**
 * @author Sunnly
 * @ClassName TbUserController
 * @Date 2019/5/31 0031 23:07
 **/
@RestController
@RequestMapping("user")
public class TbUserController {

    @Resource
    private TbUserService tbUserService;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") String id){
        return tbUserService.getUserById(id);
    }
}
