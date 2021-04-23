package com.example.demo.studentinfo.controller;

import com.example.demo.dormitoryinfo.bean.Dormitory;
import com.example.demo.login.bean.User;
import com.example.demo.studentinfo.bean.Student;
import com.example.demo.studentinfo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-19 13:37
 */
@Controller
public class StudentController {

    @Resource
    StudentService studentService;

    @RequestMapping(value = "/studentList")
    public String toStudentList(Model model, User user){
        List<Student> pageData = studentService.getStudentList(user);
        model.addAttribute("beans",pageData);
        model.addAttribute("user",user);
        return "studentList";
    }

    @RequestMapping(value = "/searchStudentList")
    public String searchStudentList(Model model, Student student, String role){
        List<Student> beans = studentService.searchStudentByno(student,role);
        model.addAttribute("beans",beans);
        return "studentList";
    }

    @RequestMapping(value = "/studentRegister")
    public String studentRegister(Model model){
        List<Dormitory> dormitoryList = studentService.getDormitoryList();
        List<User> instructorList = studentService.getinstructorList();
        model.addAttribute("dormitoryList",dormitoryList);
        model.addAttribute("instructorList",instructorList);
        return "studentRegister";
    }

    @ResponseBody
    @RequestMapping(value = "/getImage")
    public Map getImage(@RequestParam(required = false)MultipartFile file) throws IOException {
        if (file!=null){
            String imgPath = studentService.saveImage(file);
            Map<String,Object> map = new HashMap<>();
            Map<String,Object> map1 = new HashMap<>();
            map.put("code",0);
            map.put("msg","");
            map1.put("src",imgPath);
            map.put("data",map1);
            return map;
        }else {
            Map<String,Object> map = new HashMap<>();
            map.put("code",1);
            map.put("msg","并没有上传图片");
            return map;
        }
    }

    @RequestMapping(value = "/saveStudent")
    public String saveStudent(Model model, Student student) throws Exception {
        if ("".equals(student.getImgurl())||student.getImgurl()==null){
            model.addAttribute("msg","并没有上传图片");
            return "studentRegister";
        }
        boolean res = studentService.saveStudent(student);
        if (res) {
            model.addAttribute("msg2", "保存成功");
            return "studentRegister";
        }
        else{
            model.addAttribute("msg2","保存失败");
            return "studentRegister";
        }
    }


}
