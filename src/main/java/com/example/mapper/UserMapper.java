package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //查看所有用户
    public List<User> findAll(int page, int size);
    public List<User> query();
    //通过userid查看用户信息
    public User findById(String  id);
    public List<User> findByUserId(String  id);
    //新建用户
    public void add(User user);
    //修改用户信息
    public void update(User user);
    //删除用户
    public void delete(String userid);
    //修改用户权限
    public void updatePermission(User user);
    //查看用户状态
    public String queryState(String userid);
    //判断用户是否存在
    public String findExist(@Param("userid")String userid,@Param("password")String password);

}
