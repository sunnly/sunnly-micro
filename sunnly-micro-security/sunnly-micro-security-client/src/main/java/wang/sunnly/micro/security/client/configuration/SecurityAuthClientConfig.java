package wang.sunnly.micro.security.client.configuration;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.properties.SecurityProperties;
import wang.sunnly.micro.security.client.service.SecurityAuthClientFeign;
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

    //保存微服务token
    private String clientToken;

    @Autowired
    private SecurityAuthClientFeign securityAuthClientFeign;

    /**
     * 通过token换取服务信息
     * @param token
     * @return
     */
    public IJWTInfo getInfoFromToken(String token){
        try {
            return JWTHelper.getInfoFromToken(token,
                    securityProperties.getAuth().getClient().getPubKeyByte());
        } catch (ExpiredJwtException ex) {
            throw new SecurityTokenException(SecurityStatus.TOKEN_EXPIRED);
        } catch (SignatureException ex) {
            throw new SecurityTokenException(SecurityStatus.TOKEN_SIGNATURE_ERROR);
        } catch (IllegalArgumentException ex) {
            throw new SecurityTokenException(SecurityStatus.TOKEN_EMPTY);
        }catch (Exception ex){
            throw new SecurityTokenException(SecurityStatus.CLIENT_FORBIDDEN);
        }
    }

    /**
     * 每30s刷新一次允许访问的微服务列表
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void refreshAllowedClient(){
        //从鉴权服务器获取允许访问的微服务
        ObjectRestResponse<List<String>> allowClient = securityAuthClientFeign.getAllowClient(securityProperties.getAuth().getClient().getId(),
                securityProperties.getAuth().getClient().getSecret());
        if (allowClient.getStatus() == HttpStatus.OK.value()){
            this.allowedClient = allowClient.getData();
        }else{
            this.allowedClient = null;
        }

    }

    public List<String> getAllowedClient(){
        if (this.allowedClient == null)
            refreshAllowedClient();
        return this.allowedClient;
    }

    //定时刷新微服务token
    @Scheduled(cron = "0 0/10 * * * ?")
    public void refreshClientToken(){
        ObjectRestResponse<String> accessToken = securityAuthClientFeign.getAccessToken(securityProperties.getAuth().getClient().getId(),
                securityProperties.getAuth().getClient().getSecret());
        if (accessToken.getStatus() == HttpStatus.OK.value()){
            this.clientToken = accessToken.getData();
        }
    }

    public String getClientToken(){
        if (this.clientToken == null){
            //获取token
            refreshClientToken();
        }
        return this.clientToken;

    }

}
