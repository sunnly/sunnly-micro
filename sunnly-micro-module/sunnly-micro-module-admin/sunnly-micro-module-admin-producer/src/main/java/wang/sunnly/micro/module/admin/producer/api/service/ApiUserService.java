package wang.sunnly.micro.module.admin.producer.api.service;

import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.common.core.entity.UserInfo;

import java.util.List;

/**
 * @author Sunnly
 * @Inteface UserService
 * @Date 2019/6/18 15:24
 * @Version 1.0
 */

public interface ApiUserService {

    UserInfo validate(String username, String password);

    List<PermissionInfo> getPermisssionByUsername(String username);

    List<PermissionInfo> getAllPermission();
}
