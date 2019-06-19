package wang.sunnly.micro.module.admin.producer.api.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.common.core.entity.UserInfo;
import wang.sunnly.micro.module.admin.producer.entity.TbPermission;
import wang.sunnly.micro.module.admin.producer.entity.TbUser;
import wang.sunnly.micro.module.admin.producer.api.service.ApiUserService;
import wang.sunnly.micro.module.admin.producer.service.TbPermissionService;
import wang.sunnly.micro.module.admin.producer.service.TbUserService;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName UserServiceImpl
 * @Date 2019/6/18 15:24
 * @Version 1.0
 */
@Service
public class ApiUserServiceImpl implements ApiUserService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @Override
    public UserInfo validate(String username, String password) {
        UserInfo info = new UserInfo();
        TbUser tbUser = tbUserService.getUserByUsername(username);
        if (encoder.matches(password, tbUser.getPassword())){
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
        List<PermissionInfo> list = Lists.newLinkedList();
        List<TbPermission> tbPermissions = tbPermissionService.getAllPermission();
        tbPermission2PermissionInfo(tbPermissions,list);
        return list;
    }

    private void tbPermission2PermissionInfo(List<TbPermission> tbPermissions,
                                             List<PermissionInfo> list) {
//        TODO 目前只是测试，后期重新设计数据库对其进行封装
         for (TbPermission tbp : tbPermissions){
            PermissionInfo permissionInfo = new PermissionInfo();
            permissionInfo.setCode(tbp.getEnname());
            permissionInfo.setMenu(tbp.getParentId()+"");
            permissionInfo.setUri(tbp.getUrl());
            permissionInfo.setName(tbp.getName());
            permissionInfo.setMethod(tbp.getMethod());
            permissionInfo.setType(tbp.getDisplay());
            list.add(permissionInfo);
        }

    }

}
