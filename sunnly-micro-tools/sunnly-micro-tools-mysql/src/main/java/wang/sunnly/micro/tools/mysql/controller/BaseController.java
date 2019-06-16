package wang.sunnly.micro.tools.mysql.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import wang.sunnly.micro.common.web.msg.BaseResponse;
import wang.sunnly.micro.common.web.msg.ListRestResponse;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.tools.mysql.service.BaseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sunnly
 * @ClassName BaseController
 * @Date 2019/6/15 0015 23:57
 **/

@Api(value = "基类控制器", tags = {"基类控制器接口"})
public class BaseController<S extends BaseService,E> {

    @Resource
    public S service;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询（基类）", notes = "根据ID查询信息，返回ObjectRestResponse")
    public ObjectRestResponse<E> getOne(
            @ApiParam(value = "查询ID", name = "id", required = true)
            @PathVariable("id") Object id){
        ObjectRestResponse<E> objectObjectRestResponse = new ObjectRestResponse<>();
        Object obj = service.selectById(id);
        objectObjectRestResponse.data((E)obj);
        return objectObjectRestResponse;
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("")
    @ApiOperation(value = "分页查询记录数（基类）", notes = "根据页数和条数查询记录")
    public ListRestResponse<E> getPage(
            @ApiParam(name = "pageSize", value = "每页多少条", defaultValue = "10", required = false)
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @ApiParam(name = "pageNo", value = "第几页", defaultValue = "1", required = false)
            @RequestParam(value = "pageNo", defaultValue = "1")  int pageNo){
        ListRestResponse<E> listRestResponse = new ListRestResponse<>();
        List list = service.selectListByPage(pageNo,pageSize);
        listRestResponse.setCount(service.selectCount());
        listRestResponse.setResult(list);
        return listRestResponse;
    }

    /**
     * 添加
     * @param entity
     * @return
     */
    @PostMapping("")
    @ApiOperation(value = "添加记录信息（基类）", notes = "添加记录")
    public BaseResponse add(
            @ApiParam(value = "记录对象", name = "entity", required = true)
            @RequestBody E entity){
        service.insert(entity);
        return new BaseResponse();
    }

    /**
     * 修改
     * @param entity
     * @return
     */
    @PutMapping("")
    @ApiOperation(value = "修改记录信息（基类）", notes = "修改记录")
    public BaseResponse update(
            @ApiParam(value = "记录对象", name = "entity", required = true)
            @RequestBody E entity){
        service.updateById(entity);
        return new BaseResponse();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除记录（基类）", notes = "根据ID删除记录")
    public BaseResponse del(
            @ApiParam(value = "记录ID", name = "id", required = true)
            @PathVariable("id") Object id){
        service.deleteById(id);
        return new BaseResponse();
    }

}
