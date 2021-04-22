package com.example.demo.login.service;

import com.example.demo.login.bean.User;
import com.example.demo.login.dao.LoginDao;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
