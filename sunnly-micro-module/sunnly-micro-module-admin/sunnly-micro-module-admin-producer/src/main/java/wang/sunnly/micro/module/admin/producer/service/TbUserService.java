package wang.sunnly.micro.module.admin.producer.service;

import wang.sunnly.micro.module.admin.producer.entity.TbUser;
import wang.sunnly.micro.module.admin.producer.mapper.TbUserMapper;
import wang.sunnly.micro.tools.mysql.service.BaseService;

public interface TbUserService extends BaseService<TbUserMapper,TbUser> {

    public TbUser getUserByUsername(String username);
}
