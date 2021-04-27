package com.example.demo.doorcontrol.controller;

import com.example.demo.doorcontrol.service.DoorService;
import com.example.demo.studentinfo.bean.Student;
import com.lzw.face.FaceHelper;
import com.seetaface2.model.RecognizeResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-22 15:56
 */
@Controller
public class DoorController {

    @Resource
    DoorService doorService;

    @RequestMapping(value = "/doorcontrolOut")
    public String toDoorControlOut(Model model){
        List<Student> studentList = doorService.getStuList();
        model.addAttribute("studentList",studentList);
        return "doorcontrolOut";
    }

    @RequestMapping(value = "/doorcontrolIn")
    public String toDoorControlIn(Model model){
//        List<Student> studentList = doorService.getStuList();
//        model.addAttribute("studentList",studentList);
        return "doorcontrolIn";
    }

    @ResponseBody
    @RequestMapping(value = "/getCurFace")
    public Map getCurFace(@RequestParam(required = false) MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        if (file!=null){
            map.put("code",0);
            InputStream inputStream = file.getInputStream();
            BufferedImage img = ImageIO.read(inputStream);
            RecognizeResult recognizeResult = FaceHelper.search(img);
            inputStream.close();
            if (recognizeResult.similar<0.6){
                map.put("msg","相似度过低");
            }else {
                int index = recognizeResult.index;
                Student student = doorService.getMatchStudent(index);
                String msg = doorService.backDormitory(student);
                student.setStustatus(msg);
                map.put("msg",student);
            }
        }
        else {
            map.put("code",1);
            map.put("msg","并没有上传图片");
        }
        return map;
    }

    @RequestMapping(value = "stuGoOut")
    public String stuGoOut(Model model,Integer pid){
        List<Student> studentList = doorService.getStuList();
        model.addAttribute("studentList",studentList);
        Student student = doorService.stuGoOut(pid);
        model.addAttribute("msg",student.getSname()+"已出寝室");
        return "doorcontrolOut";
    }




}
