package wang.sunnly.micro.tools.validate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import wang.sunnly.micro.tools.validate.service.ValidateCodeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Sunnly
 * @ClassName ValidateCodeController
 * @Date 2019/6/10 0010 20:51
 **/
@RestController
@RequestMapping("/code")
public class ValidateCodeController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ValidateCodeService validateCodeService;

    @GetMapping("/{type}/{id}")
    public void genCode(@PathVariable("type") String type,
                        @PathVariable("id") String id,
                        HttpServletRequest request, HttpServletResponse response){
//        logger.info(String.format("【%s】:验证码为：%s",type,"3242342"));
        validateCodeService.genValidateCode(new ServletWebRequest(request,response),type, id);
    }

    @GetMapping("/{type}/{id}/{code}")
    public boolean validateCode(@PathVariable("type") String type,
                             @PathVariable("id") String id,
                             @PathVariable("code") String code,
                             HttpServletRequest request, HttpServletResponse response){
        return validateCodeService.validate(new ServletWebRequest(request, response), type, id, code);
    }
}
