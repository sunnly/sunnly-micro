package wang.sunnly.micro.module.admin.producer.service.impl;

import org.springframework.stereotype.Service;
import wang.sunnly.micro.module.admin.producer.mapper.TbUserMapper;
import wang.sunnly.micro.module.admin.producer.service.TbUserService;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.micro.tools.mysql.service.impl.BaseServiceImpl;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import javax.annotation.Resource;

@Service
public class TbUserServiceImpl<M extends MyMapper<E>,E>
        extends BaseServiceImpl<M,E>
        implements TbUserService<M, E>, BaseService<M,E> {

    @Resource
    private TbUserMapper tbUserMapper;


}
