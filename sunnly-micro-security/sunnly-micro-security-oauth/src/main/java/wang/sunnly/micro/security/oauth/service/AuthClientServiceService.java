package wang.sunnly.micro.security.oauth.service;

import wang.sunnly.micro.security.oauth.entity.AuthClientService;
import wang.sunnly.micro.security.oauth.entity.AuthClientServiceExample;

import java.util.List;

public interface AuthClientServiceService{


    long countByExample(AuthClientServiceExample example);

    int deleteByExample(AuthClientServiceExample example);

    List<AuthClientService> selectByExample(AuthClientServiceExample example);

    int updateByExampleSelective(AuthClientService record, AuthClientServiceExample example);

    int updateByExample(AuthClientService record, AuthClientServiceExample example);

}
