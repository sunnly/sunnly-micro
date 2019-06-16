package wang.sunnly.micro.tools.validate.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;
import wang.sunnly.micro.tools.validate.service.MailValidateService;

import javax.servlet.ServletOutputStream;
import java.io.IOException;

/**
 * @author Sunnly
 * @ClassName MailValidateServiceImpl
 * @Date 2019/6/10 0010 21:53
 **/
public class MailValidateServiceImpl implements MailValidateService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean sender(ServletWebRequest request, String mail, String code) {
        logger.info(String.format("向用户【%s】发送邮件：%s",mail,code));
        ServletOutputStream out = null;
        try {
            request.getResponse().setContentType("text/html;charset=UTF-8");
            request.getResponse().setCharacterEncoding("UTF-8");
            out = request.getResponse().getOutputStream();
            out.write(String.format("向用户【%s】发送邮件：%s",mail,code).getBytes());
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out !=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
