package com.lesson.demo05.service.impl;

import com.lesson.demo05.entity.User;
import com.lesson.demo05.mapper.UserMapper;
import com.lesson.demo05.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisServiceImpl implements MyBatisService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getid(Integer id) {
        System.out.println(id);
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
