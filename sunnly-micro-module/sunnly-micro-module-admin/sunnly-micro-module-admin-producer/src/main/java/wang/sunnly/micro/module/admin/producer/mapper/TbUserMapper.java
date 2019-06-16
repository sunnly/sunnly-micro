package wang.sunnly.micro.module.admin.producer.mapper;

import org.apache.ibatis.annotations.Param;
import wang.sunnly.micro.module.admin.producer.entity.TbUser;
import wang.sunnly.micro.module.admin.producer.entity.TbUserExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbUserMapper extends MyMapper<TbUser> {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    List<TbUser> selectByExample(TbUserExample example);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);
}