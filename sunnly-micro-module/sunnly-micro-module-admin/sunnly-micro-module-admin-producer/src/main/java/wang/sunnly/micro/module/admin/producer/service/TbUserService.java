package wang.sunnly.micro.module.admin.producer.service;

import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface TbUserService<M extends MyMapper<E>,E> extends BaseService<M,E> {

}
