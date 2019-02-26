package com.lesson13.demo13.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.ibatis.type.Alias;

/**
 * customers
 */
@Table(name = "customers")
@Alias("customers")
public class Customers {
    /**
     * 我是id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 我是名字
     */
    @Column(name = "name")
    private String name;

    /**
     * 我是id
     * @return id 我是id
     */
    public Long getId() {
        return id;
    }

    /**
     * 我是id
     * @param id 我是id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 我是名字
     * @return name 我是名字
     */
    public String getName() {
        return name;
    }

    /**
     * 我是名字
     * @param name 我是名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
