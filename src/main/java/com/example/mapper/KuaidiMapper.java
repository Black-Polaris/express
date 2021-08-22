package com.example.mapper;

import com.example.entity.Kuaidi;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KuaidiMapper {
    //查看所有快递
    public List<Kuaidi> findAll(int page, int size);
    public List<Kuaidi> query();
    //通过id查看快递详情
    public Kuaidi findById(String  id);
    //添加快递
    public void add(Kuaidi kuaidi);
    //更新快递信息
    public void update(Kuaidi kuaidi);
    //根据电话查看快递信息
    public List<Kuaidi> findByPhone(String phone,int page,int size);
    //删除快递
    public void delete(Kuaidi kuaidi);

}
