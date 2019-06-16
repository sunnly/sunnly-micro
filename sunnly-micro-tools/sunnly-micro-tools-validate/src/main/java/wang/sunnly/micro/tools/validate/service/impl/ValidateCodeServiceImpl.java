package wang.sunnly.micro.tools.validate.service.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.ServletWebRequest;
import wang.sunnly.micro.tools.validate.properties.ValidateCodeProperties;
import wang.sunnly.micro.tools.validate.service.*;

/**
 * @author Sunnly
 * @ClassName ValidateCodeServiceImpl
 * @Date 2019/6/10 0010 21:21
 **/
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ImageValidateService imageValidateService;
    @Autowired
    private SmsValidateService smsValidateService;
    @Autowired
    private MailValidateService mailValidateService;

    @Autowired
    private ValidateCodeProperties validateCodeProperties;

    @Autowired
    private ValidateCodeStorage validateCodeStorage;

    @Override
    public void genValidateCode(ServletWebRequest request, String type, String id) {
        String code = "";
        String key = "";
        //制作验证码
        switch (StringUtils.upperCase(type)){
            case "IMAGE":
                code = genCode(validateCodeProperties.getImage().getLength());

                key = StringUtils.defaultIfEmpty(validateCodeProperties.getImage().getKey(),"IMAGE_VALIDATE_CODE");
                //存储验证码
                validateCodeStorage.save(request,key,id,code);
                imageValidateService.sender(request, code, validateCodeProperties.getImage().getWidth(),
                        validateCodeProperties.getImage().getHeight());
                break;
            case "SMS":
                code = genCode(validateCodeProperties.getSms().getLength());

                key = StringUtils.defaultIfEmpty(validateCodeProperties.getSms().getKey(),"SMS_VALIDATE_CODE");
                //存储验证码
                validateCodeStorage.save(request,key,id,code);
                smsValidateService.sender(request,id,code);
                break;
            case "MAIL":
                code = genCode(validateCodeProperties.getMail().getLength());
                key = StringUtils.defaultIfEmpty(validateCodeProperties.getMail().getKey(),"MAIL_VALIDATE_CODE");
                //存储验证码
                validateCodeStorage.save(request,key,id,code);
                mailValidateService.sender(request,id,code);
                break;
        }


    }

    @Override
    public boolean validate(ServletWebRequest request, String type, String id, String code) {
        String key = "";
        switch (StringUtils.upperCase(type)){
            case "IMAGE":
                key = StringUtils.defaultIfEmpty(validateCodeProperties.getImage().getKey(),"IMAGE_VALIDATE_CODE");
                break;
            case "SMS":
                key = StringUtils.defaultIfEmpty(validateCodeProperties.getSms().getKey(),"SMS_VALIDATE_CODE");
                break;
            case "MAIL":
                key = StringUtils.defaultIfEmpty(validateCodeProperties.getMail().getKey(),"MAIL_VALIDATE_CODE");
                break;
        }
        return validateCodeStorage.validate(request,key,id,code);
    }

    private String genCode(int length){
        return RandomStringUtils.randomNumeric(length);
    }
}
