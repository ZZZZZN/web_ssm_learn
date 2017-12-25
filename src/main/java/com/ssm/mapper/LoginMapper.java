package com.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface LoginMapper {
     Map selectUserByUser_name(@Param("username") String username);


}