package com.lesson.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class Demo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo01Application.class, args);
    }


    @RequestMapping("/")
    public String index() {
        return "hello spring boot";
    }

    @RequestMapping("/rest")
    @ResponseBody
    public Map<Integer, Object> rest() {
        Map<Integer, Object> data = new HashMap<Integer, Object>();
        data.put(1, "a");
        data.put(2, "b");
        data.put(3, "c");
        data.put(4, "d");
        return data;
    }

}
