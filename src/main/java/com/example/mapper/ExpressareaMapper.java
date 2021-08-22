package com.example.mapper;

import com.example.entity.Expressarea;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExpressareaMapper {
    //查看快递网点
    public List<Expressarea> searchOutlets(String address);
    //申请网点
    public void outletsApply(Expressarea expressarea);

}
