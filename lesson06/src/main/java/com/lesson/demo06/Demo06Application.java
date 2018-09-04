package com.lesson.demo06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.lesson.demo06")
@EnableTransactionManagement
public class Demo06Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo06Application.class, args);
    }
}
