package com.example.demo.doorcontrol.service;

import com.example.demo.doorcontrol.bean.DoorEntity;
import com.example.demo.doorcontrol.dao.DoorDao;
import com.example.demo.studentinfo.bean.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    public String backDormitory(Student student) { //更改学生状态并且保存记录表
        DoorEntity doorEntity = new DoorEntity();
        doorEntity.setStuid(student.getPid());
        doorEntity.setInstructorid(student.getInstructorid());
        Date curTime = new Date();
        //获取当前时间，如果比23点晚并且比6点早就算晚寝
        int curhour = curTime.getHours();
        int weekDay = curTime.getDay();
        String str = "";
        if (curhour>=23||(curhour>=0&&curhour<6)){//未按时归寝
            str = "未按时归寝";
            doorEntity.setIslate("晚归");
        }else {
            str = "正常归寝";
            doorEntity.setIslate("正常");
        }
        student.setStustatus(str);
        doorDao.stuBack(student);
        doorEntity.setBackdate(curTime);
        doorEntity.setWeekday(weekDay);
        doorDao.saveRecord(doorEntity);
        return str;

    }

    public List<Student> getStuList() {
        return doorDao.getStuList();
    }

    public Student stuGoOut(Integer pid) {
        doorDao.stuGoOut(pid);
        Student student = doorDao.getStuByPid(pid);
        return student;
    }
}
