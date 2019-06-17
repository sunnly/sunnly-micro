package wang.sunnly.micro.module.test.producer.service;

import wang.sunnly.micro.module.test.producer.entity.TbPermissionExample;
import wang.sunnly.micro.module.test.producer.mapper.TbPermissionMapper;
import wang.sunnly.micro.module.test.producer.entity.TbPermission;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbPermissionService<M extends MyMapper<E>,E> extends BaseService<M,E> {

}
