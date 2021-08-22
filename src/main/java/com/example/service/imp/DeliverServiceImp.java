package com.example.service.imp;

import com.example.entity.Deliver;
import com.example.mapper.DeliverMapper;
import com.example.service.DeliverService;
import com.github.pagehelper.PageHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliverServiceImp implements DeliverService {
    @Autowired
    DeliverMapper deliverMapper;

    @Override
    public List<Deliver> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return deliverMapper.query();
    }

    @Override
    public List<Deliver> query() {
        return deliverMapper.query();
    }

    @Override
    public Deliver findById(String phone) {
        return deliverMapper.findById(phone);
    }

    @Override
    public List<Deliver> findByArea(String area, int page, int size) {
        PageHelper.startPage(page,size);
        return deliverMapper.findByArea(area);
    }

    @Override
    public void add(Deliver deliver) {
        deliverMapper.add(deliver);
    }

    @Override
    public void update(Deliver deliver) {
        deliverMapper.update(deliver);
    }

    @Override
    public void delete(String phone) {
        deliverMapper.delete(phone);
    }
}
