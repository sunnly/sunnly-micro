package wang.sunnly.micro.security.oauth.service.impl;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wang.sunnly.micro.common.core.entity.JWTAuthenticationUser;
import wang.sunnly.micro.common.core.entity.UserInfo;
import wang.sunnly.micro.common.core.exception.UserInvalidException;
import wang.sunnly.micro.common.core.status.UserInvalidStatus;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.utils.jwt.JWTHelper;
import wang.sunnly.micro.security.core.utils.jwt.JWTInfo;
import wang.sunnly.micro.security.oauth.service.AuthUserFeign;
import wang.sunnly.micro.security.oauth.service.AuthUserService;
import wang.sunnly.micro.security.oauth.utils.JWTTokenUtils;

import java.util.Map;

/**
 * 用户相关token服务
 * @Author Sunnly
 * @create 2019年6月19日 11:12:23
 **/
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserFeign authUserFeign;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

    @Override
    public String getToken(JWTAuthenticationUser user) throws Exception {
        Map<String, String> map = Maps.newHashMap();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        //验证用户
        UserInfo validate = authUserFeign.validate(map);
        if (StringUtils.isNotEmpty(validate.getId())){
            //获取token
            return jwtTokenUtils.generateToken(new JWTInfo(validate.getUsername(),validate.getId(),validate.getName()));
        }
        throw new UserInvalidException(UserInvalidStatus.USER_PASS_INVALID_CODE);
    }

    @Override
    public String refeshToken(String token) throws Exception {
        return jwtTokenUtils.generateToken(jwtTokenUtils.getInfoByToken(token));
    }

    @Override
    public void validate(String token) throws Exception {
        jwtTokenUtils.getInfoByToken(token);
    }
}
