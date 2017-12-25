package com.ssm.service;

import com.ssm.mapper.LoginMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


/**
 * Created by Administrator on 2017/12/6.
 */
@Service
public class Loginservice {
    @Resource
    private LoginMapper loginMapper;

    public Map selectUserByUser_name(String username){
        return loginMapper.selectUserByUser_name(username);
    }

}
