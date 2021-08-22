package com.example.service.imp;

import com.example.entity.Kuaidichange;
import com.example.mapper.KuaidichangeMapper;
import com.example.service.KuaidichangeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KuaidichangeServiceImp implements KuaidichangeService {
    @Autowired
    KuaidichangeMapper kuaidichangeMapper;
    @Override
    public List<Kuaidichange> findById(String kuaidiNum) {
        return kuaidichangeMapper.findById(kuaidiNum);
    }

    @Override
    public void insert(Kuaidichange kuaidichange) {
        kuaidichangeMapper.insert(kuaidichange);
    }
}
