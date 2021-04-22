package com.example.demo.login.dao;

import com.example.demo.login.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDao {
    Integer checkUserPassword(User user);
    User checkUserRole(User user);
}
