package com.lesson.demo06.engity.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class CustomerListener {
    /***
     * 数据传入前做什么
     * @param source
     */
    @PrePersist
    public void prePersist(Object source) {
        System.out.println("数据传入数据库前"+source);
    }

    /***
     * 数据传入后做什么
     * @param source
     */
    @PostPersist
    public void postPersist(Object source) {
        System.out.println("数据传入后做什么"+source);
    }

}
