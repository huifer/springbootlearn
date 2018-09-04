package com.lesson.demo06.engity;

import com.lesson.demo06.engity.listener.CustomerListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/***
 * 客户
 */
@Entity
@Access(value = AccessType.FIELD)
@Table(name = "customers")
@EntityListeners(value = {CustomerListener.class})
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
