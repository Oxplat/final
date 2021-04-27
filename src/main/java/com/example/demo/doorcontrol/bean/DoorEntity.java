package com.example.demo.doorcontrol.bean;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: Tanghao
 * @Date: 2021-04-25 9:27
 */
@Data
public class DoorEntity {
    private Integer pid;
    private Integer stuid;
    private Integer instructorid;
    private Date backdate;
    private Integer weekday;
    private String islate;
}
