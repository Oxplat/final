package com.example.demo.studentinfo.service;

import com.example.demo.login.bean.User;
import com.example.demo.login.service.LoginService;
import com.example.demo.studentinfo.bean.Student;
import com.example.demo.studentinfo.dao.StudentDao;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-19 13:39
 */
@Service
public class StudentService {

    @Resource
    StudentDao studentDao;
    @Resource
    LoginService loginService;

    public List<Student> getStudentList(User user) {
        if ("管理员".equals(user.getRole())){
            List<Student> pageData = studentDao.getAllPageData();
            return pageData;
        }else {
            List<Student> pageData = studentDao.getPartPageData(user);
            return pageData;
        }
    }

    public List<Student> searchStudentByno(Student student, String role) {
        if ("管理员".equals(role)){
            List<Student> pageData = studentDao.getDataByNo(student);
            return pageData;
        }else {
            List<Student> pageData = studentDao.getPartDataByNo(student);
            return pageData;
        }
    }

    public boolean saveStudent(Student student) throws IOException {

        boolean res = studentDao.saveStudent(student);
        return res;
    }

    public String saveImage(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString().substring(0,5)+name;
        String filePath = "F:\\project\\final\\src\\main\\resources\\images\\"+newFileName;
        File file1 = new File(filePath);
        file.transferTo(file1);
        return filePath;
    }
}
