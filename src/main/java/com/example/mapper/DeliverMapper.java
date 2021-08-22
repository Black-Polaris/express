package com.example.mapper;

import com.example.entity.Deliver;
import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface DeliverMapper {
    //查看所有快递员
    public List<Deliver> findAll(int page, int size);
    public List<Deliver> query();
    //通过电话号码查看快递员信息
    public Deliver findById(String phone);
    public List<Deliver> findByArea(String area);
    //新建快递员
    public void add(Deliver deliver);
    //修改快递员信息
    public void update(Deliver deliver);
    //删除快递员
    public void delete(String phone);
}
