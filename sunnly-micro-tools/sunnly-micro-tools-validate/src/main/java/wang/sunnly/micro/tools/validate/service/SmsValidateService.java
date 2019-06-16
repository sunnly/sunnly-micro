package wang.sunnly.micro.tools.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Sunnly
 * @ClassName ValidateService
 * @Date 2019/6/10 0010 21:36
 **/
public interface SmsValidateService {

    public boolean sender(ServletWebRequest request, String phone, String code);
}
