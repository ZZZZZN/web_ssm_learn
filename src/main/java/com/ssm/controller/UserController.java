package com.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.ssm.service.Userservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/12/6.
 */
@SuppressWarnings({ "rawtypes" })
@Controller
public class UserController {
    @Resource
    private Userservice userservice;


    @RequestMapping("index/userlistUI")
    public String userlistUI (){
        return "user/userlist";
    }

    @RequestMapping("index/userlist")
    @ResponseBody
    public JSONArray userlist(){
        JSONArray userlist=userservice.selectuserlist();
        return userlist;
    }
}
