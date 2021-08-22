package com.example.service;

import com.example.entity.Expressarea;

import java.util.List;

public interface ExpressareaService {
    //查看快递网点
    public List<Expressarea> searchOutlets(String address);
    //申请网点
    public void outletsApply(Expressarea expressarea);
}
