package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    //登录跳转页面
    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session){
        String ifPermission = userService.findExist(username,password);
        if("admin".equals(username) &&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/admin";
        }else if("true".equals(ifPermission)){
            session.setAttribute("loginUser",username);
            return "redirect:/main";
        }else{
            model.addAttribute("msg","用户名或者密码错误或者没有权限！");
            return "login";
        }
    }
    //注册
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public String userRegister(@RequestParam("username")String username,@RequestParam("userid")String userid,
                               @RequestParam("password")String password,@RequestParam("phone")String phone){
        User user = new User().setUsername(username).setUserid(userid).setPassword(password).setPhone(phone).setPermission("true");
        userService.add(user);
        return "redirect:/login";
    }

    //注销
    @RequestMapping("/loginOut")
    public String loginOut(Model model, HttpSession session){
        session.invalidate();
        return "login";
    }

}
