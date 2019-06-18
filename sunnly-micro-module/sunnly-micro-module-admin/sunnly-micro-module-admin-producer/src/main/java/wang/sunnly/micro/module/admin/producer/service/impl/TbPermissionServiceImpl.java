package wang.sunnly.micro.module.admin.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.module.admin.producer.entity.TbPermission;
import wang.sunnly.micro.module.admin.producer.mapper.TbPermissionMapper;
import wang.sunnly.micro.module.admin.producer.service.TbPermissionService;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.micro.tools.mysql.service.impl.BaseServiceImpl;

import java.util.List;

//@Service
public class TbPermissionServiceImpl
        extends BaseServiceImpl<TbPermissionMapper,TbPermission>
        implements TbPermissionService, BaseService<TbPermissionMapper,TbPermission> {

    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<PermissionInfo> getPermisssionByUsername(String username) {
        return tbPermissionMapper.getPermisssionByUsername();
    }

}
