package wang.sunnly.micro.module.admin.producer.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wang.sunnly.micro.common.core.entity.PermissionInfo;
import wang.sunnly.micro.module.admin.producer.entity.TbPermission;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

@Repository
public interface TbPermissionMapper extends MyMapper<TbPermission> {

    @Select("SELECT p.* FROM tb_user AS u \n" +
            "LEFT JOIN tb_user_role AS ur ON u.id = ur.user_id \n" +
            "LEFT JOIN tb_role AS r ON r.id = ur.role_id \n" +
            "LEFT JOIN tb_role_permission AS rp ON r.id = rp.role_id \n" +
            "LEFT JOIN tb_permission AS p ON p.id = rp.permission_id \n" +
            "WHERE u.username = #{username}")
    List<PermissionInfo> getPermisssionByUsername();
}