package com.lesson12.demo12.onwWayOneToMany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>Title : Productom </p>
 * <p>Description : 产品</p>
 *
 * @author huifer
 * @date 2018/11/05
 */
@Entity
@Table(name = "t_product_otm")
public class Productom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Productom() {

    }

    public Productom(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Productom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
