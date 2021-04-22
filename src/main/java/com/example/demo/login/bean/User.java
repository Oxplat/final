package com.example.demo.login.bean;

import lombok.Data;

@Data
public class User {
    private Integer pid;
    private String username;
    private String password;
    private String role;
    private String realname;
    private String phone;
}
