package com.example.demo.dormitoryinfo.service;

import com.example.demo.dormitoryinfo.bean.Dormitory;
import com.example.demo.dormitoryinfo.dao.DormitoryDao;
import com.example.demo.login.bean.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-22 10:19
 */
@Service
public class DormitoryService {

    @Resource
    DormitoryDao dormitoryDao;

    public List<Dormitory> getDormitoryList(User user) {
        if ("管理员".equals(user.getRole())){
            List<Dormitory> pageData = dormitoryDao.getAllPageData();
            return pageData;
        }else {
            List<Dormitory> pageData = dormitoryDao.getPartPageData(user);
            return pageData;
        }
    }

    public void saveDormitory(Dormitory dormitory) {
        for (Integer i=1;i<=Integer.parseInt(dormitory.getLayerno());i++){
            //层号
            for (Integer j=1;j<=Integer.parseInt(dormitory.getRoomno());j++){
                //房间号
                for (Integer k=1;k<=Integer.parseInt(dormitory.getBedno());k++){
                    //床位号
                    String layerno = "";
                    String roomno = "";
                    if (i<10) {
                        layerno = "0"+i;
                    }else {
                        layerno = i.toString();
                    }
                    if (j<10) {
                        roomno = "0"+j;
                    }else {
                        roomno = j.toString();

                    }
                    String bedno = "0"+k;
                    String dormitorycode = dormitory.getBuildno()+layerno+roomno+bedno;
                    Dormitory dormitory1 = new Dormitory();
                    dormitory1.setDormitorycode(dormitorycode);
                    dormitory1.setBuildno(dormitory.getBuildno());
                    dormitory1.setLayerno(layerno+"楼");
                    dormitory1.setRoomno(roomno+"号房");
                    dormitory1.setBedno(bedno+"号床");
                    dormitory1.setBedstatus("未入住");
                    dormitoryDao.saveDormitory(dormitory1);
                }
            }
        }
    }
}
