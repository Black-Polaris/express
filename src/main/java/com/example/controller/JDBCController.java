package com.example.controller;

import com.example.entity.Kuaidi;
import com.example.mapper.KuaidiMapper;
import com.example.service.KuaidiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
public class JDBCController {

//    private  JdbcTemplate jdbcTemplate;
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//    @GetMapping("/userList")
//    public List<Map<String,Object>> userList(){
//        String sql = "select *from kuaidi";
//        List<Map<String ,Object>> list = jdbcTemplate.queryForList(sql);
//        return list;
//    }
    @Autowired
    KuaidiService kuaidiService;
    @GetMapping("/query")
    public String query(Model model){
        List<Kuaidi> kuaidis = kuaidiService.query();
        model.addAttribute("kuaidiList",kuaidis);
        return "index";
    }

//    private KuaidiMapper kuaidiMapper;
//    @Autowired
//    public void setKuaidiMapper(KuaidiMapper kuaidiMapper){
//        this.kuaidiMapper = kuaidiMapper;
//    }
//    @GetMapping("/query")
//    public String  query(Model model){
//        List<Kuaidi> kuaidis = kuaidiMapper.query();
////        for(Kuaidi kuaidi:kuaidis){
////            System.out.println(kuaidi);
////        }
//        model.addAttribute("kuaidiList",kuaidis);
//        return "index";
//    }

}
