package wang.sunnly.micro.security.oauth.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wang.sunnly.micro.security.core.status.SecurityStatus;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.utils.client.ClientInfo;
import wang.sunnly.micro.security.core.utils.jwt.JWTHelper;
import wang.sunnly.micro.security.oauth.entity.AuthClient;
import wang.sunnly.micro.security.oauth.mapper.AuthClientMapper;
import wang.sunnly.micro.security.oauth.properties.SshKeyProperties;
import wang.sunnly.micro.security.oauth.service.AuthClientServices;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthClientServicesImpl implements AuthClientServices {

    @Resource
    private AuthClientMapper authClientMapper;

    //生成jwt 时的有效时长
    @Value("${sunnly.security.auth.client.expire}")
    private int expire = 3600;

    @Autowired
    private SshKeyProperties sshKeyProperties;

    @Override
    public String generateToken(String clientId, String secret) throws Exception {
        //验证clientId和secret的合法性
        AuthClient client = getClient(clientId, secret);
        //生成token
        return JWTHelper.generateToken(new ClientInfo(client.getCode(),client.getName(),client.getId().toString()),
                sshKeyProperties.getServicePriKey(),expire);
    }

    @Override
    public List<String> getAllowClient(String clientId, String secret) {
        AuthClient client = getClient(clientId, secret);
        List<String> allowClient = authClientMapper.getAllowClient(client.getId());
        return allowClient == null ? Lists.<String>newArrayList() : allowClient;
    }

    @Override
    public void validate(String clientId, String secret){
        getClient(clientId,secret);
    }

    private AuthClient getClient(String clientId, String secret){
        if (StringUtils.isEmpty(clientId)|| StringUtils.isEmpty(secret)){
            throw new SecurityTokenException(SecurityStatus.CLIENT_OR_SECRENT_ERROR);
        }
        AuthClient client = new AuthClient();
        client.setCode(clientId);
        client = authClientMapper.selectOne(client);
        if (client !=null && !StringUtils.equals(client.getSecret(),secret)){
            //clientId和secret非法
            throw new SecurityTokenException(SecurityStatus.CLIENT_OR_SECRENT_ERROR);
        }
        return client;
    }

}
