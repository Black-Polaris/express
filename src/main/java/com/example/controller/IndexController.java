package com.example.controller;

import com.example.entity.*;
import com.example.service.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    KuaidiService kuaidiService;
    @Autowired
    UserService userService;
    @Autowired
    DeliverService deliverService;
    @Autowired
    ExpressareaService expressareaService;
    @Autowired
    KuaidichangeService kuaidichangeService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    //跳转后台
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String list(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "5") int size){
        List<Kuaidi> kuaidis = kuaidiService.findAll(page,size);
        PageInfo<Kuaidi> pageInfo = new PageInfo(kuaidis);
        model.addAttribute("pageInfo",pageInfo);
        return "adminIndex";
    }
    //跳转到用户管理
    @RequestMapping(value = "/userManager",method = RequestMethod.GET)
    public String userManager(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "5") int size){
        List<User> users = userService.findAll(page,size);
        PageInfo<User> pageInfo = new PageInfo(users);
        model.addAttribute("pageInfo",pageInfo);
        return "userList";
    }
    //跳转快递员管理
    @RequestMapping(value = "/deliverManager",method = RequestMethod.GET)
    public String deliverManager(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "5") int size){
        List<Deliver> delivers = deliverService.findAll(page,size);
        PageInfo<User> pageInfo = new PageInfo(delivers);
        model.addAttribute("pageInfo",pageInfo);
        return "deliverList";
    }
    //跳转到提交快递信息页面
    @RequestMapping(value = "/mail/online")
    public String mail(){
        return "mail";
    }
    //跳转到快递管理页面
    @RequestMapping(value = "/mailManager")
    public String mailManager(Model model, @RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required=true,defaultValue = "5") int size){
        List<Kuaidi> kuaidis = kuaidiService.findAll(page,size);
        PageInfo<Kuaidi> pageInfo = new PageInfo(kuaidis);
        model.addAttribute("pageInfo",pageInfo);
        return "mailExpress";
    }
    //查找快递
    @RequestMapping(value = "/searchKuaidi" ,method = RequestMethod.GET)
    public String searchKuaidi(Model model,@RequestParam(name = "kuaidiNum") String kuaidiNum){
        List<Kuaidichange> kuaidichanges = kuaidichangeService.findById(kuaidiNum);
        model.addAttribute("kuaidiNum",kuaidiNum);
        model.addAttribute("kuaidichanges",kuaidichanges);
        return "search";
    }
    //网点管理
    @RequestMapping(value = "/outletsManager")
        public String outletsManager(){
            return "outlets";
        }

    //查找网点
    @RequestMapping(value = "/searchOutlets",method = RequestMethod.GET)
    public String searchOutlets(Model model,@RequestParam(name = "address") String address){
        List<Expressarea> expressareas = expressareaService.searchOutlets(address);
        model.addAttribute("address",address);
        StringBuffer sb = new StringBuffer();
        for (Expressarea epressarea:expressareas) {
            sb.append(epressarea.getArea()+" ");
        }
        model.addAttribute("area",sb);
        return "search2";
    }
    //网点申请
    @RequestMapping(value = "/outletsApply",method = RequestMethod.POST)
    public String outletsApply(@RequestParam("areaName")String areaName, @RequestParam("manageName")String manageName,
                               @RequestParam("areaPhone")String areaPhone, @RequestParam("address") String address,
                               @RequestParam("area") String area){
        Expressarea expressarea = new Expressarea().setAreaName(areaName).setManageName(manageName)
                .setAreaPhone(areaPhone).setAddress(address).setArea(area);
        expressareaService.outletsApply(expressarea);
        return "outletsSuccess";
    }
    //模拟快递转运
    @RequestMapping(value = "/outletsChange",method = RequestMethod.POST)
    public String outletsChange(@RequestParam("kuaidiNum") String kuaidiNum,@RequestParam("currentArea")String currentArea,@RequestParam("nextArea")String nextArea)  {
        Kuaidichange kuaidichange = new Kuaidichange().setKuaidiNum(kuaidiNum).setCurrentArea(currentArea).setNextArea(nextArea);
        kuaidichangeService.insert(kuaidichange);
        return "outletsChangeSuccess";
    }


    //寄快递操作判断是否账号登录处理
    @RequestMapping(value = "/searchIfLogin",method = RequestMethod.POST)
    public String searchIfLogin(@RequestParam("loginUser")String loginUser){
        if(loginUser.equals("")&&loginUser.isEmpty()){
            return "/login";
        }else{
            return "/mailOnline";
        }
    }

    @RequestMapping(value = "/mailOnline")
    public String mailOnline(){
        return "mailOnline";
    }

}
