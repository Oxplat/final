package com.example.demo.backdormitoryrecord.dao;

import com.example.demo.backdormitoryrecord.bean.EchartsEntity;
import com.example.demo.backdormitoryrecord.bean.LateBackRecoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-26 14:26
 */
@Repository
@Mapper
public interface BackRecordDao {

    List<LateBackRecoEntity> getInforEcharts();

    EchartsEntity getNormalBack();

    EchartsEntity getLateBack();

    EchartsEntity getNoBack();

    List<LateBackRecoEntity> getLateBackInfo();

    List<LateBackRecoEntity> getNoBackInfo();
}
