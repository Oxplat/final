package com.example.demo.login.controller;

import com.example.demo.login.bean.User;
import com.example.demo.login.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
public class LoginController {

    @Resource
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String Login(Model model, User user) {

        if (user.getUsername()==null||"".equals(user.getUsername())){
            model.addAttribute("msg","用户名不能为空");
            return "login";
        }else if (user.getPassword()==null||"".equals(user.getPassword())){
            model.addAttribute("msg","密码不能为空");
            return "login";
        }
        Integer pid = loginService.CheckUserPW(user);
        if (pid!=null&&pid!=0){
            user.setPid(pid);
            User roleChkUser = loginService.CheckUserRole(user);
            if (roleChkUser!=null){
                model.addAttribute("user",roleChkUser);
                return "homepage";
            }else {
                model.addAttribute("msg","请正确选择身份");
                return "login";
            }
        }
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }

}
