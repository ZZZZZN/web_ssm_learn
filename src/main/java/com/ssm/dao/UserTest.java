package com.ssm.dao;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class UserTest {
    private Integer id;

    private String email;

    private String password;

    private String username;

    private String role;

    private Integer status;

    private Date regtime;

    private String regip;

}