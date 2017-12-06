package com.ssm.mapper;

import com.alibaba.fastjson.JSONArray;
import com.ssm.dao.UserTest;

public interface UserTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTest record);

    int insertSelective(UserTest record);

    UserTest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTest record);

    int updateByPrimaryKey(UserTest record);

    JSONArray selectuserlist();
}