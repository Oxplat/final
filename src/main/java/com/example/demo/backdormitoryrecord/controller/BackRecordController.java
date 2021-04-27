package com.example.demo.backdormitoryrecord.controller;

import com.example.demo.backdormitoryrecord.bean.EchartsEntity;
import com.example.demo.backdormitoryrecord.bean.LateBackRecoEntity;
import com.example.demo.backdormitoryrecord.service.BackRecordService;
import com.example.demo.studentinfo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-26 14:26
 */
@Controller
public class BackRecordController {

    @Resource
    BackRecordService backRecordService;

    @RequestMapping(value = "/backEcharts")
    public String toBackEcharts(){
        return "backEcharts";
    }

    @ResponseBody
    @RequestMapping(value = "/getEcharts")
    public Map toGetEcharts(){
        Map<String,Object> map = new HashMap<>();
        EchartsEntity normal = backRecordService.getNormalBack();
        EchartsEntity late = backRecordService.getLateBack();
        EchartsEntity no = backRecordService.getNolBack();
        int[] normalBack = {normal.getDay1(),normal.getDay2(),normal.getDay3(),normal.getDay4(),normal.getDay5(),normal.getDay6(),normal
        .getDay7()};
        int[] lateBack = {late.getDay1(),late.getDay2(),late.getDay3(),late.getDay4(),late.getDay5(),late.getDay6(),late.getDay7()};
        int[] noBack = {no.getDay1(),no.getDay2(),no.getDay3(),no.getDay4(),no.getDay5(),no.getDay6(),no.getDay7()};
        map.put("normalBack",normalBack);
        map.put("lateBack",lateBack);
        map.put("noBack",noBack);
        return map;
    }

    @RequestMapping(value = "/lateBackReco")
    public String toLateBackReco(Model model){
//        List<>  backRecordService.getLateBackInfo();
        return "lateBackReco";
    }


}
