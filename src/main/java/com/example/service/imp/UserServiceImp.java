package com.example.service.imp;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return userMapper.query();
    }

    @Override
    public List<User> query() {
        return userMapper.query();
    }

    @Override
    public List<User> findByUserId(String id, int page, int size) {
        PageHelper.startPage(page,size);
        return userMapper.findByUserId(id);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }


    @Override
    public void delete(String userid) {
        userMapper.delete(userid);
    }

    @Override
    public void updatePermission(User user) {
        userMapper.updatePermission(user);
    }

    @Override
    public String queryState(String userid) {
       return userMapper.queryState(userid);
    }

    @Override
    public String findExist(String userid, String password) {
        return userMapper.findExist(userid,password);
    }
}
