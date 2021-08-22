package com.example.controller;

import com.example.entity.Deliver;
import com.example.entity.Kuaidi;
import com.example.entity.User;
import com.example.service.DeliverService;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeliverController {
    @Autowired
    DeliverService deliverService;

    //跳转用户信息修改页面
    @RequestMapping(value = "/deliver/toChange/{id}",method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id")String id){
        Deliver deliver = deliverService.findById(id);
        model.addAttribute("deliver",deliver);
        return "deliverUpdate";
    }
    //修改用户信息
    @RequestMapping(value = "/deliver/toChange",method = RequestMethod.POST)
    public String toChange(@RequestParam("deliverName") String deliverName,
                           @RequestParam("phone") String phone,
                           @RequestParam("area") String area){
        Deliver deliver = new Deliver().setDeliverName(deliverName).setPhone(phone).setArea(area);

        deliverService.update(deliver);
        return "redirect:/deliverManager";
    }
    //删除用户
    @RequestMapping(value = "/deliver/toDelete/{id}")
    public String delete(@PathVariable("id") String id){
        deliverService.delete(id);
        return "redirect:/deliverManager";
    }
    //根据地区查找快递员
    @RequestMapping(value = "deliver/get",method = RequestMethod.GET)
    public String findByArea(Model model,@RequestParam(name="area") String area, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "10") int size){
        List<Deliver> delivers = deliverService.findByArea(area,page,size);
        PageInfo<Deliver> pageInfo = new PageInfo(delivers);
        model.addAttribute("pageInfo",pageInfo);
        return "deliverList";
    }
    //跳转添加页面
    @RequestMapping(value = "/deliver/toAdd")
    public String toAdd(){
        return "deliverAdd";
    }
    //添加用户
    @RequestMapping(value = "/delivertoAdd",method = RequestMethod.POST)
    public String add(@RequestParam("deliverName")String deliverName, @RequestParam("phone")String phone,
                      @RequestParam("area") String area){
        Deliver deliver=new Deliver().setDeliverName(deliverName).setPhone(phone).setArea(area);
        //添加用户
        deliverService.add(deliver);
        return "redirect:/deliverManager";
    }

}
