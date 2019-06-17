package wang.sunnly.micro.module.test.producer.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import wang.sunnly.micro.module.test.producer.entity.TbPermissionExample;
import wang.sunnly.micro.module.test.producer.mapper.TbPermissionMapper;
import wang.sunnly.micro.module.test.producer.entity.TbPermission;
import wang.sunnly.micro.module.test.producer.service.TbPermissionService;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.micro.tools.mysql.service.impl.BaseServiceImpl;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

@Service
public class TbPermissionServiceImpl <M extends MyMapper<E>,E>
        extends BaseServiceImpl<M,E>
        implements TbPermissionService<M, E>, BaseService<M,E> {


}
