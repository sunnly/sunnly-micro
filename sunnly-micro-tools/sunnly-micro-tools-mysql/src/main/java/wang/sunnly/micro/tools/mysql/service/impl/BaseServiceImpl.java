package wang.sunnly.micro.tools.mysql.service.impl;

import com.github.pagehelper.PageHelper;
import wang.sunnly.micro.common.web.entity.MyExample;
import wang.sunnly.micro.common.web.msg.ListRestResponse;
import wang.sunnly.micro.common.web.msg.ObjectRestResponse;
import wang.sunnly.micro.common.web.msg.TableResultResponse;
import wang.sunnly.micro.tools.mysql.service.BaseService;
import wang.sunnly.tk.mybatis.mapper.MyMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Sunnly
 * @ClassName BaseServiceImpl
 * @Date 2019/6/16 0016 0:03
 **/
public class BaseServiceImpl<M extends MyMapper<E>,E>
        implements BaseService<M, E> {

    @Resource
    protected M mapper;

    @Override
    public E selectOne(E entity) {
        return mapper.selectOne(entity);
    }

    @Override
    public E selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<E> selectList(E entity) {
        return mapper.select(entity);
    }

    @Override
    public List<E> selectByExample(MyExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public List<E> selectListAll() {
        return mapper.selectAll();
    }

    @Override
    public List<E> selectListByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return mapper.selectAll();
    }

    @Override
    public List<E> selectList(MyExample example, int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return mapper.selectAll();
    }

    @Override
    public TableResultResponse<E> selectToTableRestResponse(MyExample example, int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        return new TableResultResponse<E>(mapper.selectCountByExample(example),
                mapper.selectByExample(example));
    }

    @Override
    public ObjectRestResponse<E> selectToObjectRestResponse(MyExample example){
        return new ObjectRestResponse<>().data(mapper.selectOneByExample(example));
    }

    @Override
    public ObjectRestResponse<E> selectToObjectRestResponse(E entity){
        return new ObjectRestResponse<>().data(mapper.selectOne(entity));
    }

    @Override
    public ListRestResponse<E> selectToListRestResponse(MyExample example, int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        ListRestResponse<E> result = new ListRestResponse<>();
        result.setCount(mapper.selectCountByExample(example));
        result.setResult(selectByExample(example));
        return result;
    }

    @Override
    public int selectCount(E entity) {
        return mapper.selectCount(entity);
    }

    @Override
    public long countByExample(MyExample example){
        return mapper.selectCountByExample(example);
    }

    @Override
    public int selectCount(){
        return mapper.selectCount(null);
    }

    @Override
    public int selectCount(MyExample example){
        return mapper.selectCountByExample(example);
    }
    @Override
    public void insert(E entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(E entity) {
        mapper.insertSelective(entity);
    }

    @Override
    public void delete(E entity) {
        mapper.delete(entity);
    }

    @Override
    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateById(E entity) {
        mapper.updateByPrimaryKey(entity);
    }

    @Override
    public void updateSelectiveById(E entity) {
        mapper.updateByPrimaryKeySelective(entity);
    }
}
