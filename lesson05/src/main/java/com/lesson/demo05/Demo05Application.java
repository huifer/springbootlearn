package com.lesson.demo05;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lesson.demo05.mapper"})
public class Demo05Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo05Application.class, args);
    }
}
