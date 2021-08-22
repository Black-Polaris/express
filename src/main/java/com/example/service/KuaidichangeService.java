package com.example.service;

import com.example.entity.Kuaidi;
import com.example.entity.Kuaidichange;

import java.util.List;

public interface KuaidichangeService {
    //通过id查看快递详情
    public List<Kuaidichange> findById(String kuaidiNum);
    //插入快递转运信息
    public void insert(Kuaidichange kuaidichange);
}
