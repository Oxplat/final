package com.example.demo.backdormitoryrecord.service;

import com.example.demo.backdormitoryrecord.bean.EchartsEntity;
import com.example.demo.backdormitoryrecord.bean.LateBackRecoEntity;
import com.example.demo.backdormitoryrecord.dao.BackRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-26 14:26
 */
@Service
public class BackRecordService {

    @Resource
    BackRecordDao backRecordDao;

    public EchartsEntity getNormalBack() {
        return backRecordDao.getNormalBack();
    }

    public EchartsEntity getLateBack() {
        return backRecordDao.getLateBack();
    }

    public EchartsEntity getNoBack() {
        return backRecordDao.getNoBack();
    }

    public List<LateBackRecoEntity> getLateBackInfo() {
        return backRecordDao.getLateBackInfo();
    }

    public List<LateBackRecoEntity> getNoBackInfo() {
        return backRecordDao.getNoBackInfo();
    }
}
