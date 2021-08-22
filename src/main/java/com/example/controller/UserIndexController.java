package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserIndexController {
    @RequestMapping(value = "/toPage",method = RequestMethod.GET)
    public  String toPage(HttpServletRequest request){
        String url = request.getParameter("url");
        System.out.println("redirect:"+url);
        return "redirect:"+url;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String userIndex(){
        return "login";
    }
}
