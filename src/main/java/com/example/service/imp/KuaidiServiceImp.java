package com.example.service.imp;

import com.example.entity.Kuaidi;
import com.example.mapper.KuaidiMapper;
import com.example.service.KuaidiService;
import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KuaidiServiceImp implements KuaidiService {
    @Autowired
    KuaidiMapper kuaidiMapper;
    @Override
    public List<Kuaidi> query() {
        return kuaidiMapper.query();
    }

    @Override
    public List<Kuaidi> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return kuaidiMapper.query();
    }

    @Override
    public Kuaidi findById(String id) {
        return kuaidiMapper.findById(id);
    }

    @Override
    public void add(Kuaidi kuaidi) {
        kuaidiMapper.add(kuaidi);
    }

    @Override
    public void update(Kuaidi kuaidi) {
        kuaidiMapper.update(kuaidi);
    }

    @Override
    public List<Kuaidi> findByPhone(String phone,int page,int size) {
        PageHelper.startPage(page,size);
        return kuaidiMapper.findByPhone(phone,page,size);
    }
    @Override
    public void delete(Kuaidi kuaidi) {
        kuaidiMapper.delete(kuaidi);
    }
}
