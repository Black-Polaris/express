package com.example.service.imp;

import com.example.entity.Expressarea;
import com.example.mapper.ExpressareaMapper;
import com.example.service.ExpressareaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExpressareaServiceImp implements ExpressareaService {
    @Autowired
    ExpressareaMapper expressareaMapper;

    @Override
    public List<Expressarea> searchOutlets(String address) {
        return expressareaMapper.searchOutlets(address);
    }

    @Override
    public void outletsApply(Expressarea expressarea) {
        expressareaMapper.outletsApply(expressarea);
    }
}
