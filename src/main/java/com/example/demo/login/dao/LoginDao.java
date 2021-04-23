package com.example.demo.login.dao;

import com.example.demo.login.bean.User;
import com.example.demo.studentinfo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginDao {
    Integer checkUserPassword(User user);
    User checkUserRole(User user);

    List<Student> getAllStudent();

    void updStuInx(Student bean);
}
