package wang.sunnly.micro.module.admin.producer.rpc.service;

import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.common.core.entity.UserInfo;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName UserService
 * @Date 2019/6/18 15:24
 * @Version 1.0
 */
public interface RpcUserService {

    UserInfo validate(String username, String password);

    List<PermissionInfo> getPermisssionByUsername(String username);

    List<PermissionInfo> getAllPermission();
}
