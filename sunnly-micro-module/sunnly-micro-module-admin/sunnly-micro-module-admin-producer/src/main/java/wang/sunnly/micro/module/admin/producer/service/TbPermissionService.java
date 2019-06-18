package wang.sunnly.micro.module.admin.producer.service;

import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.module.admin.producer.entity.TbPermission;
import wang.sunnly.micro.module.admin.producer.mapper.TbPermissionMapper;
import wang.sunnly.micro.module.admin.producer.entity.TbPermissionExample;
import wang.sunnly.micro.tools.mysql.service.BaseService;

import java.util.List;

public interface TbPermissionService extends BaseService<TbPermissionMapper,TbPermission> {

    List<PermissionInfo> getPermisssionByUsername(String username);

    List<TbPermission> getAllPermission();
}
