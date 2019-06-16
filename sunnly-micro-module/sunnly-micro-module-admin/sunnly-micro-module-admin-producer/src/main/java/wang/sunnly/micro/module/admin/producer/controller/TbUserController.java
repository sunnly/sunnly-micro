package wang.sunnly.micro.module.admin.producer.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import wang.sunnly.micro.common.web.msg.BaseResponse;
import wang.sunnly.micro.common.web.msg.ListRestResponse;
import wang.sunnly.micro.module.admin.producer.entity.TbUser;
import wang.sunnly.micro.module.admin.producer.service.TbUserService;
import wang.sunnly.micro.tools.mysql.controller.BaseController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author Sunnly
 * @ClassName TbUserController
 * @Date 2019/5/31 0031 22:33
 **/
@RestController
@RequestMapping("/user")
@Api(value = "用户列表API",
        tags = {"用户列表接口"})
public class TbUserController extends BaseController<TbUserService, TbUser> {

    @ApiOperation(value = "根据id查询用户信息", notes = "查询数据库中某个的用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/stu/{id}", method = RequestMethod.GET)
    public Object getUser(@PathVariable int id) {
        return service.selectById(id);
    }

    @ApiOperation(value = "测试插入用户信息", notes = "测试插入用户信息，需要复写父类方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", paramType ="query", value = "用户ID"),
            @ApiImplicitParam(name = "username", paramType ="query", value = "用户名"),
            @ApiImplicitParam(name = "password", paramType ="query", value = "密码"),
            @ApiImplicitParam(name = "phone", paramType ="query", value = "注册手机号"),
            @ApiImplicitParam(name = "email", paramType ="query", value = "注册邮箱"),
            @ApiImplicitParam(name = "created", paramType ="query", value = "创建日期"),
            @ApiImplicitParam(name = "updated", paramType ="query",  value = "修改日期")
    })
    @PutMapping("")
    public BaseResponse update(TbUser tbUser){
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        service.insert(tbUser);
        return new BaseResponse(200,"插入成功");
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/page")
//    @JsonView(TbUser.TbUserDetailView.class)
    @ApiOperation(value = "分页查询记录数（基类）", notes = "根据页数和条数查询记录")
    public ListRestResponse<TbUser> getUserPage(
            @Valid
            @ApiParam(name = "pageSize", value = "每页多少条", defaultValue = "10", required = false)
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @ApiParam(name = "pageNo", value = "第几页", defaultValue = "1", required = false)
            @RequestParam(value = "pageNo", defaultValue = "1")  int pageNo/*, BindingResult errors*/){
        ListRestResponse<TbUser> listRestResponse = new ListRestResponse<>();
        List list = service.selectListByPage(pageNo,pageSize);
        listRestResponse.setCount(service.selectCount());
        listRestResponse.setResult(list);
        return listRestResponse;
    }

}
