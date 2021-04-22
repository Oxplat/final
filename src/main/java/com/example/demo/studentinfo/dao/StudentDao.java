package com.example.demo.studentinfo.dao;

import com.example.demo.login.bean.User;
import com.example.demo.studentinfo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-19 13:57
 */
@Mapper
@Repository
public interface StudentDao {
    List<Student> getAllPageData();
    List<Student> getPartPageData(User user);
    List<Student> getDataByNo(Student student);
    List<Student> getPartDataByNo(Student student);
    Boolean saveStudent(Student student);
}
