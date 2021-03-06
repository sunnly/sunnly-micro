package wang.sunnly.micro.security.client.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.security.client.service.SecurityAuthClientFeign;
import wang.sunnly.micro.security.core.properties.SecurityProperties;

/**
 * @author Sunnly
 * @ClassName RefreshPubKeyRunner
 * @Date 2019/6/16 0016 23:27
 **/
@Configuration
//@Slf4j
@EnableScheduling
public class RefreshPubKeyRunner implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityAuthClientFeign securityAuthClientFeign;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void run(String... args) throws Exception {
        try {
            log.info("初始化用户PubKey");
            getUserPublicKey();
            log.info("初始化服务pubKey");
            getServicePublicKey();
        }catch (Exception e){
            log.info("PubKey初始化失败");
            e.printStackTrace();
        }


    }

    /**
     * 定时刷新验证clientId和secret是否发生改变
     */
    @Scheduled(cron = "0 0/50000 * * * ?")
    public void validateClientIdAndSecret(){
        //鉴权服务端提供获取servicePubKey接口
        try {
            boolean validate = securityAuthClientFeign.validateClientIdAndSecret(
                    securityProperties.getAuth().getClient().getId(),
                    securityProperties.getAuth().getClient().getSecret());
            if (validate) {
                //验证成功
                return;
            }
        }catch (Exception e){}
        //TODO 验证失败,清除信息
        securityProperties.getAuth().getClient().setPubKeyByte(null);
        securityProperties.getAuth().getUser().setPubKeyByte(null);
    }

    /**
     *
     * 如果pubKey为空，则去重新获取
     *
     * @Author Sunnly
     * @Date
     * @Param
     * @return
     **/
    @Scheduled(cron = "0 0/10000 * * * ?")
    public void validateClientIdAndSecret1(){
        if (RefreshPubKeyRunner.isNull(securityProperties.getAuth().getUser().getPubKeyByte())
                || RefreshPubKeyRunner.isNull(securityProperties.getAuth().getClient().getPubKeyByte())){
            log.info("重新获取用户PubKey");
            getUserPublicKey();
            log.info("重新获取服务PubKey");
            getServicePublicKey();
        }
    }

    public static boolean isNull(byte[] bytes){
        return bytes == null || bytes.length ==0;
    }

    private void getUserPublicKey(){

        ObjectRestResponse<byte[]> userPubKey = securityAuthClientFeign.getUserPubKey(
                securityProperties.getAuth().getClient().getId(),
                securityProperties.getAuth().getClient().getSecret());
        if (userPubKey.getStatus() == HttpStatus.OK.value()){
            securityProperties.getAuth().getUser().setPubKeyByte(userPubKey.getData());
        }

    }

    private void getServicePublicKey(){
        ObjectRestResponse<byte[]> servicePubKey = securityAuthClientFeign.getServicePubKey(
                securityProperties.getAuth().getClient().getId(),
                securityProperties.getAuth().getClient().getSecret());
        if (servicePubKey.getStatus() == HttpStatus.OK.value()){
            securityProperties.getAuth().getClient().setPubKeyByte(servicePubKey.getData());
        }
    }

}
