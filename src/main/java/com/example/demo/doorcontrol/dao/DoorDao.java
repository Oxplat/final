package com.example.demo.doorcontrol.dao;

import com.example.demo.studentinfo.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
