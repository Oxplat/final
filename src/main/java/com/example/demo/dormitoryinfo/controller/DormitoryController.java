package com.example.demo.dormitoryinfo.controller;

import com.example.demo.dormitoryinfo.bean.Dormitory;
import com.example.demo.dormitoryinfo.service.DormitoryService;
import com.example.demo.login.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-22 10:19
 */
@Controller
public class DormitoryController {

    @Resource
    DormitoryService dormitoryService;

    @RequestMapping(value = "/DormitoryList")
    public String toDormitoryList(Model model, User user){
        List<Dormitory> pageData = dormitoryService.getDormitoryList(user);
        model.addAttribute("beans",pageData);
        model.addAttribute("user",user);
        return "dormitoryList";
    }

    @RequestMapping(value = "/dormitoryConfig")
    public String todormitoryConfig(Model model, User user){
        model.addAttribute("user",user);
        return "dormitoryConfig";
    }

    @RequestMapping(value = "/saveDormitory")
    public String saveDormitory(Model model, User user, Dormitory dormitory){
        dormitoryService.saveDormitory(dormitory);
        List<Dormitory> pageData = dormitoryService.getDormitoryList(user);
        model.addAttribute("user",user);
        model.addAttribute("beans",pageData);
        return "dormitoryList";
    }



}
