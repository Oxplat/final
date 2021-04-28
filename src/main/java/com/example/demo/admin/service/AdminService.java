package com.example.demo.admin.service;

import com.example.demo.admin.dao.AdminDao;
import com.example.demo.login.bean.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-28 10:25
 */
@Service
public class AdminService {

    @Resource
    AdminDao adminDao;

    public String addAdmin(User user) {
        User bean = adminDao.getUserByUN(user);
        if (bean!=null)
            return "该用户名已存在";
        else {
            adminDao.addAdmin(user);
            return "添加成功";
        }
    }

    public List<User> getUserList() {
        return adminDao.getUserList();
    }

    public User getUserById(Integer pid) {
        return adminDao.getUserById(pid);
    }

    public List<User> getAllUser() {
        return adminDao.getAllUser();
    }

    public void updAdmin(User user) {
        adminDao.updAdmin(user);
    }

    public void delAdmin(Integer pid) {
        adminDao.delAdminById(pid);
    }
}
