package com.lesson.demo02.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XMLRestDemoController {

    /***
     * 返回pojo json
     * @return
     */
    @GetMapping(path = "/xml/user",produces = MediaType.APPLICATION_XML_VALUE)
    public User user (){
        User user = new User();
        user.setAge(10);
        user.setName("xml");
        return user;
    }

}
