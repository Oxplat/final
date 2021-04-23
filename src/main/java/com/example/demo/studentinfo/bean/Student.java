package com.example.demo.studentinfo.bean;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-19 13:36
 */
@Data
public class Student {
    private Integer pid;
    private String sno;
    private String sname;
    private String ssex;
    private Integer instructorid;
    private String imgurl;
    private String instructorname;
    private String sphone;
    private Integer dormitoryid;
    private Integer index;
}
