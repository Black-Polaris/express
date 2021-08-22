package com.example.mapper;

import com.example.entity.Kuaidichange;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface KuaidichangeMapper {
    //通过id查看快递详情
    public List<Kuaidichange> findById(String kuaidiNum);
    //插入快递转运信息
    public void insert(Kuaidichange kuaidichange);
}
