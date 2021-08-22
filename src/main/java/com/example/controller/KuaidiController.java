package com.example.controller;

import com.example.entity.Kuaidi;
import com.example.service.KuaidiService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

@Controller
public class KuaidiController {
    @Autowired
    KuaidiService kuaidiService;
    //跳转到快递列表
    @RequestMapping(value = "/kuaidi/list",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "10") int size){
        List<Kuaidi> kuaidis = kuaidiService.findAll(page,size);
        PageInfo<Kuaidi> pageInfo = new PageInfo(kuaidis);
        model.addAttribute("pageInfo",pageInfo);
        return "kuaidiList";
    }
    ////跳转快递详情页面
    @RequestMapping(value = "/kuaidi/info/{id}",method = RequestMethod.GET)
    public String info(Model model, @PathVariable("id")String id){
        Kuaidi kuaidi = kuaidiService.findById(id);
        model.addAttribute("kuaidi",kuaidi);
        return "kuaidiInfo";
    }
    //跳转快递详情修改页面
    @RequestMapping(value = "/kuaidi/update/{id}",method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id")String id){
        Kuaidi kuaidi = kuaidiService.findById(id);
        model.addAttribute("kuaidi",kuaidi);
        return "kuaidiUpdate";
    }
    //更新快递信息
    @RequestMapping(value = "/kuaidi/updateKuaidi",method = RequestMethod.POST)
    public String update(@RequestParam("kuaidiNum") String kuaidiNum,@RequestParam("username")String username,@RequestParam("receiveName") String receiveName,
                         @RequestParam("phone") String phone,@RequestParam("receivePhone") String receivePhone,
                         @RequestParam("sendReceiveAddress") String sendReceiveAddress,@RequestParam("createTime") String  createTime) throws ParseException {
        String[] s = sendReceiveAddress.split("->");
        String sendAddress = s[0];
        String receiveAddress = s[1];
        SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) sb.parse(createTime);
        Timestamp timeStamp = new Timestamp(date.getTime());
        System.out.println(createTime);
        System.out.println(timeStamp);

        Kuaidi kuaidi = new Kuaidi().setKuaidiNum(kuaidiNum).setUsername(username)
                .setPhone(phone).setSendAddress(sendAddress).setReceiveName(receiveName)
                .setReceivePhone(receivePhone).setReceiveAddress(receiveAddress).setCreateTime(timeStamp);
        kuaidiService.update(kuaidi);
        return "redirect:/admin";
    }
    //删除快递订单
    @RequestMapping(value = "/kuaidi/toDelete/{id}")
    public String delete(@PathVariable("id") String id){
        Kuaidi kuaidi = new Kuaidi().setKuaidiNum(id);
        kuaidiService.delete(kuaidi);
        return "redirect:/admin";
    }
    //根据电话号码搜索快递信息
    @RequestMapping(value = "kuaidi/get",method = RequestMethod.GET)
    public String findByPhone(Model model,@RequestParam(name="phone") String phone, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "10") int size){
        List<Kuaidi> kuaidis = kuaidiService.findByPhone(phone,page,size);
        PageInfo<Kuaidi> pageInfo = new PageInfo(kuaidis);
        model.addAttribute("pageInfo",pageInfo);
        return "adminIndex";
    }

}
