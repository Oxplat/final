package com.example.demo.admin.dao;

import com.example.demo.login.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-28 10:25
 */
@Repository
@Mapper
public interface AdminDao {
    User getUserByUN(User user);

    void addAdmin(User user);

    List<User> getUserList();

    User getUserById(Integer pid);

    List<User> getAllUser();

    void updAdmin(User user);

    void delAdminById(Integer pid);
}
