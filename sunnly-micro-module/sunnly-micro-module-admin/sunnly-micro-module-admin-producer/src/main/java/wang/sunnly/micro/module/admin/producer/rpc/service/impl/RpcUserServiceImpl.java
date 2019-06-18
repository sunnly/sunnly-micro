package wang.sunnly.micro.module.admin.producer.rpc.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.common.core.entity.UserInfo;
import wang.sunnly.micro.module.admin.producer.entity.TbPermission;
import wang.sunnly.micro.module.admin.producer.entity.TbUser;
import wang.sunnly.micro.module.admin.producer.mapper.TbPermissionMapper;
import wang.sunnly.micro.module.admin.producer.rpc.service.RpcUserService;
import wang.sunnly.micro.module.admin.producer.service.TbPermissionService;
import wang.sunnly.micro.module.admin.producer.service.TbUserService;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName UserServiceImpl
 * @Date 2019/6/18 15:24
 * @Version 1.0
 */
public class RpcUserServiceImpl implements RpcUserService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    @Override
    public UserInfo validate(String username, String password) {
        UserInfo info = new UserInfo();
        TbUser tbUser = tbUserService.getUserByUsername(username);
        if (StringUtils.equals(tbUser.getPassword(),password)){
            BeanUtils.copyProperties(tbUser,info);
            info.setId(tbUser.getId().toString());
        }
        return info;
    }

    @Override
    public List<PermissionInfo> getPermisssionByUsername(String username) {
        return tbPermissionService.getPermisssionByUsername(username);
    }

    @Override
    public List<PermissionInfo> getAllPermission() {
        List<TbPermission> tbPermissions = tbPermissionService.selectListAll();

        return null;
    }
}
