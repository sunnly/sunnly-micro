package wang.sunnly.micro.module.test.producer.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import wang.sunnly.micro.module.test.producer.entity.TbPermission;
import wang.sunnly.micro.module.test.producer.entity.TbPermissionExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

@Repository
public interface TbPermissionMapper extends MyMapper<TbPermission> {

}