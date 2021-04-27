package com.example.demo.login.controller;

import com.example.demo.login.bean.User;
import com.example.demo.login.service.LoginService;
import com.example.demo.studentinfo.bean.Student;
import com.lzw.face.FaceHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    LoginService loginService;

    @RequestMapping(value = "/login")
    public String Login(Model model, User user) throws IOException {

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
                List<Student> studentList = loginService.getAllStudent(); //获取全部学生列表进行人脸注册
                for (Student bean: studentList){
                    if (bean.getImgurl()!=null&&!"".equals(bean.getImgurl())){
                        File file = new File(bean.getImgurl());
                        BufferedImage img = ImageIO.read(file);
                        int index = FaceHelper.register(img);
                        bean.setFaceindex(index);
                        loginService.updStuInx(bean);
                    }
                }
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
