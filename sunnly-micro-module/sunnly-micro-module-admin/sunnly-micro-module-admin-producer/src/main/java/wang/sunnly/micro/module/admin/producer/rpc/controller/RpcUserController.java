package wang.sunnly.micro.module.admin.producer.rpc.controller;

import org.springframework.web.bind.annotation.*;
import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.common.core.entity.UserInfo;
import wang.sunnly.micro.module.admin.producer.rpc.service.RpcUserService;

import java.util.List;
import java.util.Map;

/**
 * 用户验证、权限、token获取
 *
 * @author Sunnly
 * @ClassName UserValidateController
 * @Date 2019/6/18 15:07
 * @Version 1.0
 */
@RestController
@RequestMapping("api")
public class RpcUserController {

    RpcUserService rpcUserService;

    @GetMapping("/permissions")
    public @ResponseBody List<PermissionInfo> getAllPermission(){
        return rpcUserService.getAllPermission();
    }

    @GetMapping("/permissions/{username}")
    public @ResponseBody List<PermissionInfo> getPermissionByUsername(
            @PathVariable("username") String username){

        return rpcUserService.getPermisssionByUsername(username);
    }

    public @ResponseBody UserInfo validate(@RequestBody Map<String,String> body){
        return rpcUserService.validate(body.get("username"), body.get("password"));
    }
}
