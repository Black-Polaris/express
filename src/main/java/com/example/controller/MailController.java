package com.example.controller;

import com.example.entity.Kuaidi;
import com.example.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

@Controller
public class MailController {
    @Autowired
    MailService mailService;

    //寄快递，生成随机订单号和下单时间
    @RequestMapping(value = "/mail/online",method = RequestMethod.POST)
    public String add(@RequestParam("username")String username, @RequestParam("phone")String phone,@RequestParam("sendAddress") String sendAddress,
                    @RequestParam("receiveName")String receiveName, @RequestParam("receivePhone") String receivePhone,
                    @RequestParam("receiveAddress") String receiveAddress,@RequestParam("kuaidiType") String kuaidiType){
        Date date = new Date();
        String str = new SimpleDateFormat("yyyyMMdd").format(date);
        Random r = new Random();
        int rand = (int) ((r.nextDouble()*(99990-10000+1))+10000);
        String kuaidiNum = rand +"";
        Kuaidi kuaidi = new Kuaidi().setKuaidiNum(kuaidiNum).setUsername(username).setPhone(phone).setSendAddress(sendAddress)
                .setReceiveName(receiveName).setReceivePhone(receivePhone).setReceiveAddress(receiveAddress).setKuaidiType(kuaidiType);
        mailService.add(kuaidi);
        return "/mailSuccess";
    }

    @RequestMapping(value = "/mailonline",method = RequestMethod.POST)
    public String addOnline(@RequestParam("username")String username, @RequestParam("phone")String phone,@RequestParam("sendAddress") String sendAddress,
                      @RequestParam("receiveName")String receiveName, @RequestParam("receivePhone") String receivePhone,
                      @RequestParam("receiveAddress") String receiveAddress,@RequestParam("kuaidiType") String kuaidiType){

            Date date = new Date();
            String str = new SimpleDateFormat("yyyyMMdd").format(date);
            Random r = new Random();
            int rand = (int) ((r.nextDouble()*(99990-10000+1))+10000);
            String kuaidiNum = rand +"";
            Kuaidi kuaidi = new Kuaidi().setKuaidiNum(kuaidiNum).setUsername(username).setPhone(phone).setSendAddress(sendAddress)
                    .setReceiveName(receiveName).setReceivePhone(receivePhone).setReceiveAddress(receiveAddress).setKuaidiType(kuaidiType);
            mailService.add(kuaidi);
            return "/mailOnlineSuccess";
        }
}

