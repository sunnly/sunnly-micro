package wang.sunnly.micro.module.admin.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import wang.sunnly.micro.module.admin.consumer.service.impl.UserServiceFallback;

@FeignClient(value = "sunnly-micro-module-admin-producer", fallback = UserServiceFallback.class)
public interface UserService {

    @GetMapping("/user1/{id}")
    public String get(@PathVariable("id") String id);
}
