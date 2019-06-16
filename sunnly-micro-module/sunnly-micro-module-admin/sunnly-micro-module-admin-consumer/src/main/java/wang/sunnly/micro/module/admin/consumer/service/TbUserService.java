package wang.sunnly.micro.module.admin.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wang.sunnly.micro.module.admin.consumer.service.impl.TbUserServicesFallback;

@FeignClient(value = "sunnly-micro-module-admin-producer", fallback = TbUserServicesFallback.class)
public interface TbUserService {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String id);
}
