package com.example.demo.doorcontrol.service;

import com.example.demo.doorcontrol.dao.DoorDao;
import com.example.demo.studentinfo.bean.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-22 15:57
 */
@Service
public class DoorService {

    @Resource
    DoorDao doorDao;

    public Student getMatchStudent(int index) {
        return doorDao.getStuByIndex(index);
    }
}
