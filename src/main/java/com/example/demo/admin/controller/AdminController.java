package com.example.demo.admin.controller;

import com.example.demo.admin.service.AdminService;
import com.example.demo.login.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-28 10:24
 */
@Controller
public class AdminController {

    @Resource
    AdminService adminService;

    @RequestMapping(value = "/adminList")
    public String adminList(Model model,User curUser){
        List<User> users = adminService.getUserList();
        model.addAttribute("beans",users);
        model.addAttribute("curUser",curUser);
        return "adminList";
    }

    @ResponseBody
    @RequestMapping(value = "/addAdmin" , method = RequestMethod.POST)
    public Map addAdmin(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        String res = adminService.addAdmin(user);
        map.put("res",res);
        return map;
    }

    @RequestMapping(value = "/toUpdAdmin")
    public String toUpdAdmin(Model model, Integer curPid ,Integer pid, String role){
        User user = adminService.getUserById(pid);
        model.addAttribute("bean",user);
        model.addAttribute("curPid",curPid);
        if (role!=null){
            model.addAttribute("jur",role);
            List<User> userList = adminService.getAllUser();
            model.addAttribute("beans",userList);
        }
        return "editAdmin";
    }

    @RequestMapping(value = "/updateAdmin")
    public String updAdmin(Model model, Integer curPid, User user){
        adminService.updAdmin(user);
        User curUser = adminService.getUserById(curPid);
        model.addAttribute("curUser",curUser);
        List<User> users = adminService.getUserList();
        model.addAttribute("beans",users);
        return "adminList";
    }

    @RequestMapping(value = "/delAdmin")
    public String delAdmin(Model model, Integer curPid, Integer pid){
        adminService.delAdmin(pid);
        User curUser = adminService.getUserById(curPid);
        model.addAttribute("curUser",curUser);
        List<User> users = adminService.getUserList();
        model.addAttribute("beans",users);
        return "adminList";
    }

}
