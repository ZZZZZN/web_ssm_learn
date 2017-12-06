package com.ssm.service;

import com.alibaba.fastjson.JSONArray;
import com.ssm.mapper.UserTestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/12/6.
 */
@Service
public class Userservice {
    @Resource
    private UserTestMapper userTestMapper;

    public JSONArray selectuserlist(){
        return userTestMapper.selectuserlist();
    }
}
