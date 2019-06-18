package wang.sunnly.micro.module.admin.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.sunnly.micro.module.admin.producer.entity.TbUser;
import wang.sunnly.micro.module.admin.producer.mapper.TbUserMapper;
import wang.sunnly.micro.module.admin.producer.service.TbUserService;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.micro.tools.mysql.service.impl.BaseServiceImpl;

@Service
public class TbUserServiceImpl
        extends BaseServiceImpl<TbUserMapper,TbUser>
        implements TbUserService, BaseService<TbUserMapper,TbUser> {

    @Autowired
    private TbUserMapper mapper;

    @Override
    public TbUser getUserByUsername(String username) {
        return mapper.getUserByUsername(username);
    }
}
