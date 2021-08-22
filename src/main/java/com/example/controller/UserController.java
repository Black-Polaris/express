package com.example.controller;

import com.example.entity.Kuaidi;
import com.example.entity.User;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //修改用户状态
    @RequestMapping(value = "/user/changeState/{id}")
    public String changeState(@PathVariable("id") String id){
        String state = userService.queryState(id);
        User user = new User().setPermission(state.equalsIgnoreCase("false")?"true":"false").setUserid(id);
        userService.updatePermission(user);
        return "redirect:/userManager";
    }
    //跳转用户信息修改页面
    @RequestMapping(value = "/user/toChange/{id}",method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id")String id){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "userUpdate";
    }
    //修改用户信息
    @RequestMapping(value = "/user/toChange",method = RequestMethod.POST)
    public String toChange(@RequestParam("username") String username, @RequestParam("userid") String userid,
                           @RequestParam("password") String password, @RequestParam("phone") String phone,
                           @RequestParam("permission") String permission){
        User user = new User().setUsername(username).setUserid(userid).setPassword(password)
                .setPhone(phone).setPermission(permission);
        System.out.println(user.getUserid());
        userService.update(user);
        return "redirect:/userManager";
    }
    //删除用户
    @RequestMapping(value = "/user/toDelete/{id}")
    public String delete(@PathVariable("id") String id){
        userService.delete(id);
        return "redirect:/userManager";
    }
    //根据用户账号查找用户
    @RequestMapping(value = "user/get",method = RequestMethod.GET)
    public String findByUserid(Model model,@RequestParam(name="userid") String userid, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "10") int size){
        List<User> user = userService.findByUserId(userid,page,size);
        PageInfo<Kuaidi> pageInfo = new PageInfo(user);
        model.addAttribute("pageInfo",pageInfo);
        return "userList";
    }
    //跳转添加页面
    @RequestMapping(value = "/user/toAdd")
    public String toAdd(){
        return "userAdd";
    }
    //添加用户
    @RequestMapping(value = "/usertoAdd",method = RequestMethod.POST)
    public String add(@RequestParam("username")String username, @RequestParam("phone")String phone,
                      @RequestParam("userid")String userid, @RequestParam("password")String password,
                      @RequestParam("permission") String permission){
        User user=new User().setUsername(username).setPhone(phone).setUserid(userid).setPassword(password).setPermission(permission);
        //添加用户
        userService.add(user);
        return "redirect:/userManager";
    }

}
