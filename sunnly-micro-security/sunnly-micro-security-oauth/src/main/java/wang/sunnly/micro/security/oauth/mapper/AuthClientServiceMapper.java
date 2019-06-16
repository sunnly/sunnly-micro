package wang.sunnly.micro.security.oauth.mapper;

import org.apache.ibatis.annotations.Param;
import wang.sunnly.micro.security.oauth.entity.AuthClientService;
import wang.sunnly.micro.security.oauth.entity.AuthClientServiceExample;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface AuthClientServiceMapper extends MyMapper<AuthClientService> {
    long countByExample(AuthClientServiceExample example);

    int deleteByExample(AuthClientServiceExample example);

    List<AuthClientService> selectByExample(AuthClientServiceExample example);

    int updateByExampleSelective(@Param("record") AuthClientService record, @Param("example") AuthClientServiceExample example);

    int updateByExample(@Param("record") AuthClientService record, @Param("example") AuthClientServiceExample example);
}