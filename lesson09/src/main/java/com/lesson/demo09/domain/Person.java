package com.lesson.demo09.domain;

import com.lesson.demo09.bean.validation.constraints.PersonNamePrefix;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {

    @NotNull
    @PersonNamePrefix(prefix = "wa")
    private String name;

    @Min(value = 0)
    @Max(value = 200    )
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
