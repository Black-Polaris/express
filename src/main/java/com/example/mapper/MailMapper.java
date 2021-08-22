package com.example.mapper;

import com.example.entity.Kuaidi;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MailMapper {
    //提交订单
    public void add(Kuaidi kuaidi);


}
