package com.example.demo.backdormitoryrecord.bean;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-26 17:41
 */
@Data
public class LateBackRecoEntity {
    private Integer pid;
    private Integer stuid;
    private Integer instructorid;
    private Date backdate;
    private Integer weekday;
    private String islate;
    private String sno;
    private String sname;
    private String ssex;
    private String sphone;
    private String realname;
    private String phone;
}
