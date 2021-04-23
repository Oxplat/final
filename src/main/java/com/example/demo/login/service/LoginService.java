package com.example.demo.login.service;

import com.example.demo.login.bean.User;
import com.example.demo.login.dao.LoginDao;
import com.example.demo.studentinfo.bean.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {

    @Resource
    LoginDao loginDao;

    public Integer CheckUserPW(User user) {
        Integer pid = loginDao.checkUserPassword(user);
        return pid;
    }

    public User CheckUserRole(User user) {
        User gotUser = loginDao.checkUserRole(user);
        return gotUser;
    }

    public List<Student> getAllStudent() {
        return loginDao.getAllStudent();
    }

    public void updStuInx(Student bean) {
        loginDao.updStuInx(bean);
    }
}
