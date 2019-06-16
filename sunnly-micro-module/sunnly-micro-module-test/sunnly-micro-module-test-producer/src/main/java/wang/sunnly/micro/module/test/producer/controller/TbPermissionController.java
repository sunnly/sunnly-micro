package wang.sunnly.micro.module.test.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wang.sunnly.micro.common.web.msg.TableResultResponse;
import wang.sunnly.micro.module.test.producer.entity.TbPermission;
import wang.sunnly.micro.module.test.producer.entity.TbPermissionExample;
import wang.sunnly.micro.module.test.producer.service.TbPermissionService;
import wang.sunnly.micro.module.test.producer.service.TestFeign1;
import wang.sunnly.micro.security.core.exception.SecurityTokenException;
import wang.sunnly.micro.security.core.status.SecurityStatus;
import wang.sunnly.micro.tools.mysql.controller.BaseController;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName TbPermissionController
 * @Date 2019/6/16 0016 12:24
 **/
@RestController
@RequestMapping("permission")
public class TbPermissionController
        extends  BaseController<TbPermissionService, TbPermission> {

    @Autowired
    private TbPermissionService tbPermissionService;

    @GetMapping("/table")
    public TableResultResponse<TbPermission> table(
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo){

        List<TbPermission> list = service.selectListByPage(pageNo, pageSize);
//        int total = service.selectCount();
        long total = service.countByExample(new TbPermissionExample());
        return new TableResultResponse<TbPermission>(total,list);
//        return new TableResultResponse<TbPermission>(500, "error");
    }

    @GetMapping("/error")
    public TableResultResponse error(){

        throw new SecurityTokenException(SecurityStatus.CLIENT_OR_SECRENT_ERROR);
    }
    @GetMapping("/mylist")
    public TableResultResponse<List<TbPermission>> myTable(
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo){
        List list = tbPermissionService.myList(pageNo, pageSize);
        return new TableResultResponse<List<TbPermission>>(service.selectCount(),list);
    }

    @Autowired
    private TestFeign1 testFeign1;
    @GetMapping("/tt1")
    public String tt1() throws Exception {
        String userById = testFeign1.getUserById("37");
        return userById;
    }
}
