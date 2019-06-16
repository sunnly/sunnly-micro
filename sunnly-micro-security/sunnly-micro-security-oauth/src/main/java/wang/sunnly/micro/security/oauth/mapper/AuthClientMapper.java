package wang.sunnly.micro.security.oauth.mapper;

import org.apache.ibatis.annotations.Select;
import wang.sunnly.micro.security.oauth.entity.AuthClient;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface AuthClientMapper extends MyMapper<AuthClient> {

    @Select("SELECT c.CODE " +
            "FROM auth_client c " +
            "INNER JOIN auth_client_service gcs " +
            "ON gcs.client_id = c.id " +
            "WHERE gcs.service_id = #{serviceId}")
    List<String> getAllowClient(Integer id);
}