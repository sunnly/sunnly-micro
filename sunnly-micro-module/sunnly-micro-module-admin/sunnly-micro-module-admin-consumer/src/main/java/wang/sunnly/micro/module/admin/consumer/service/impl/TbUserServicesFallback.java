package wang.sunnly.micro.module.admin.consumer.service.impl;

import org.springframework.stereotype.Component;
import wang.sunnly.micro.module.admin.consumer.service.TbUserService;

/**
 * @author Sunnly
 * @ClassName TbUserServicesFallback
 * @Date 2019/5/31 0031 23:09
 **/
@Component
public class TbUserServicesFallback implements TbUserService {

    @Override
    public String getUserById(String id) {
        return "User error ";
    }
}
