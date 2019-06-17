package wang.sunnly.micro.module.demo.producer.service;

import wang.sunnly.micro.module.demo.producer.entity.TbUser;
import wang.sunnly.micro.module.demo.producer.entity.TbUserExample;
import wang.sunnly.micro.module.demo.producer.mapper.TbUserMapper;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbUserService<M extends MyMapper<E>,E> extends BaseService<M,E> {

}
