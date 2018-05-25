package com.example.test.service.impl;

import com.example.test.mapper.UserMapper;
import com.example.test.service.IRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegService implements IRegService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean regUser(String userAge, String userName) {

        Boolean flag;
        try {
            flag = userMapper.insertUsers(userAge,userName);
        }catch (Exception e){
            return false;
        }
        return flag;
    }
}