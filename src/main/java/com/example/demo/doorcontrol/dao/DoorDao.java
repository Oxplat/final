package com.example.demo.doorcontrol.dao;

import com.example.demo.doorcontrol.bean.DoorEntity;
import com.example.demo.studentinfo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-22 15:57
 */
@Repository
@Mapper
public interface DoorDao {
    Student getStuByIndex(int index);

    void saveRecord(DoorEntity doorEntity);

    List<Student> getStuList();

    void stuGoOut(Integer pid);

    Student getStuByPid(Integer pid);

    void stuBack(Student student);
}
