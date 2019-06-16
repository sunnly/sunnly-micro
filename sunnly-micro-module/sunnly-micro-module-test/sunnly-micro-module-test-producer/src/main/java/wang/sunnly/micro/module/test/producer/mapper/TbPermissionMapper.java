package wang.sunnly.micro.module.test.producer.mapper;

import org.apache.ibatis.annotations.Select;
import wang.sunnly.micro.module.test.producer.entity.TbPermission;
import wang.sunnly.micro.module.test.producer.entity.TbPermissionExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface TbPermissionMapper extends MyMapper<TbPermission> {

    @Select("SELECT * FROM tb_permission LIMIT #{start},#{size}")
    public List<TbPermission> myList(int start, int size);
}