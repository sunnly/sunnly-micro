package wang.sunnly.micro.module.demo.producer.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import wang.sunnly.micro.module.demo.producer.entity.TbUser;
import wang.sunnly.micro.module.demo.producer.entity.TbUserExample;
import wang.sunnly.micro.module.demo.producer.mapper.TbUserMapper;
import wang.sunnly.micro.module.demo.producer.service.TbUserService;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.micro.tools.mysql.service.impl.BaseServiceImpl;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

@Service
public class TbUserServiceImpl<M extends MyMapper<E>,E>
        extends BaseServiceImpl<M,E>
        implements TbUserService<M, E>, BaseService<M,E> {


}
