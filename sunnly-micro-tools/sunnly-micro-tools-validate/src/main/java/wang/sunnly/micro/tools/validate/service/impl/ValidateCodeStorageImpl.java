package wang.sunnly.micro.tools.validate.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import wang.sunnly.micro.tools.validate.service.ValidateCodeStorage;

/**
 * @author Sunnly
 * @ClassName ValidateCodeStorageImpl
 * @Date 2019/6/10 0010 23:28
 **/
public class ValidateCodeStorageImpl implements ValidateCodeStorage {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void save(ServletWebRequest request, String key, String id, String code){
        sessionStrategy.setAttribute(request,String.format("%s_%s",key,id),code);
    }

    @Override
    public boolean validate(ServletWebRequest request, String key, String id, String code) {
        return validate(request,key,id,code,false);
    }

    @Override
    public boolean validateAnyIgnoreCase(ServletWebRequest request, String key, String id, String code) {
        return validateAnyIgnoreCase(request,key,id,code,false);
    }

    @Override
    public boolean validate(ServletWebRequest request, String key, String id, String code,boolean clear) {
        String storeCode = (String) sessionStrategy.getAttribute(request, String.format("%s_%s", key, id));
        if (clear)
            sessionStrategy.setAttribute(request,String.format("%s_%s",key,id),null);
        return StringUtils.isNoneEmpty(storeCode) && StringUtils.equals(storeCode,code);
    }

    @Override
    public boolean validateAnyIgnoreCase(ServletWebRequest request, String key, String id, String code,boolean clear) {
        String storeCode = (String) sessionStrategy.getAttribute(request, String.format("%s_%s", key, id));
        if (clear)
            sessionStrategy.setAttribute(request,String.format("%s_%s",key,id),null);
        return StringUtils.isNoneEmpty(storeCode) && StringUtils.equalsAnyIgnoreCase(storeCode,code);
    }
}
