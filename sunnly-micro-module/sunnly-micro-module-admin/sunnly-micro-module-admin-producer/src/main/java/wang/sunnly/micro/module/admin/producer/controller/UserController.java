package wang.sunnly.micro.module.admin.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sunnly
 * @ClassName UserController
 * @Date 2019/5/31 0031 20:14
 **/

@RestController
@ApiIgnore
public class UserController {

//    @Value("${server.port}")
//    private int port;

    @GetMapping("/user1/{id}")
    public String get(@PathVariable("id") String id,
                      HttpServletRequest request){
//        if (port == 0){
          int  port = request.getServerPort();
//        }
        return "Hello, 【" + port + "】 This is your ID:"+id;
    }
}
