package com.lesson.demo05.controller;

import com.lesson.demo05.entity.User;
import com.lesson.demo05.service.MyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private MyBatisService myBatisService;


    @GetMapping("/user/{id}")
    public User get(@PathVariable Integer id) {
        System.out.println("=================");
        System.out.println(id);
        User getid = myBatisService.getid(id);
        System.out.println(getid);
        return getid;
    }


}
