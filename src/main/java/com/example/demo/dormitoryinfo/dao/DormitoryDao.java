package com.example.demo.dormitoryinfo.dao;

import com.example.demo.dormitoryinfo.bean.Dormitory;
import com.example.demo.login.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-22 10:20
 */
@Mapper
@Repository
public interface DormitoryDao {
    List<Dormitory> getAllPageData();

    List<Dormitory> getPartPageData(User user);

    void saveDormitory(Dormitory dormitory1);
}
