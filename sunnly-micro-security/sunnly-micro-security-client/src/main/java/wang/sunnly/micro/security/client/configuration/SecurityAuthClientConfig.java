package wang.sunnly.micro.security.client.configuration;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import wang.sunnly.micro.security.client.properties.SecurityProperties;
import wang.sunnly.micro.security.core.status.SecurityStatus;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.utils.jwt.IJWTInfo;
import wang.sunnly.micro.security.core.utils.jwt.JWTHelper;

import java.security.SignatureException;
import java.util.List;

/**
 *
 * 由于服务鉴权管理员可能会修改，故需要定时去获取允许访问的服务
 *
 * @author Sunnly
 * @ClassName SecurityAuthServiceController
 * @Date 2019/6/13 0013 20:59
 **/
@Configuration
@Slf4j
@EnableScheduling
public class SecurityAuthClientConfig {

    @Autowired
    private SecurityProperties securityProperties;

    //保存允许访问的服务
    private List<String> allowedClient;

    /**
     * 通过token换取服务信息
     * @param token
     * @return
     */
    public IJWTInfo getInfoFromToken(String token) throws Exception{
        try {
            return JWTHelper.getInfoFromToken(token,
                    securityProperties.getAuth().getClient().getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new SecurityTokenException(SecurityStatus.TOKEN_EXPIRED);
        } catch (SignatureException ex) {
            throw new SecurityTokenException(SecurityStatus.TOKEN_SIGNATURE_ERROR);
        } catch (IllegalArgumentException ex) {
            throw new SecurityTokenException(SecurityStatus.TOKEN_EMPTY);
        }
    }

    /**
     * 每30s刷新一次允许访问的微服务列表
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient(){
        //从鉴权服务器获取允许访问的微服务
        this.allowedClient = null;
    }

    public List<String> getAllowedClient(){
        if (this.allowedClient == null)
            refreshAllowedClient();
        return this.allowedClient;
    }

}
