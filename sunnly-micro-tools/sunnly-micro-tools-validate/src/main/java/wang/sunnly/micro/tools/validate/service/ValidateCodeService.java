package wang.sunnly.micro.tools.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Sunnly
 * @ClassName ValidateCodeService
 * @Date 2019/6/10 0010 21:17
 **/
public interface ValidateCodeService {

    public void genValidateCode(ServletWebRequest request, String type, String id);

    public boolean validate(ServletWebRequest request, String type, String id, String code);
}
