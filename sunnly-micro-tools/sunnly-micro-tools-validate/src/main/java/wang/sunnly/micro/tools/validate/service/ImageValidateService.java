package wang.sunnly.micro.tools.validate.service;

import org.springframework.web.context.request.ServletWebRequest;

public interface ImageValidateService {
    public boolean sender(ServletWebRequest request, String code, int width, int height);

}
