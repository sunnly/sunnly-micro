package wang.sunnly.micro.module.demo.producer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import wang.sunnly.micro.module.demo.producer.entity.TbUser;
import wang.sunnly.micro.module.demo.producer.entity.TbUserExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

public interface TbUserMapper extends MyMapper<TbUser> {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    List<TbUser> selectByExample(TbUserExample example);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);
}