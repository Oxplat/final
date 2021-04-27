package com.example.demo.doorcontrol.service;

import com.example.demo.doorcontrol.bean.DoorEntity;
import com.example.demo.doorcontrol.dao.DoorDao;
import com.example.demo.studentinfo.bean.Student;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-26 11:22
 */
@Service
public class LateBackTask {

    @Resource
    DoorDao doorDao;

    @Scheduled(cron = "0 0 23 * * ? ")
    public void cheackLateBack(){
        List<Student> studentList = doorDao.getStuList();
        for (Student student : studentList){
            if ("外出".equals(student.getStustatus())){
                student.setStustatus("未归");
                doorDao.stuBack(student);
                DoorEntity doorEntity = new DoorEntity();
                Date date = new Date();
                Integer weekday = date.getDay();
                doorEntity.setStuid(student.getPid());
                doorEntity.setInstructorid(student.getInstructorid());
                doorEntity.setBackdate(date);
                doorEntity.setWeekday(weekday);
                doorEntity.setIslate("未归");
                doorDao.saveRecord(doorEntity);
            }
        }
    }

}
