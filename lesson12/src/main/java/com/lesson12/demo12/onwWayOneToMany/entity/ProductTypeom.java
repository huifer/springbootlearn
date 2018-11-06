package com.lesson12.demo12.onwWayOneToMany.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <p>Title : ProductTypeom </p>
 * <p>Description : 产品类型 一对多</p>
 *
 * @author huifer
 * @date 2018/11/05
 */
@Entity
@Table(name = "t_product_type_otm")
public class ProductTypeom {
    @Id
    @GeneratedValue
    private Long id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Productom.class)
    @JoinColumn(name = "type_id")
    private Set<Productom> products = new HashSet<Productom>();

    public ProductTypeom() {
    }

    @Override
    public String toString() {
        return "ProductTypeom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
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

    public Set<Productom> getProducts() {
        return products;
    }

    public void setProducts(Set<Productom> products) {
        this.products = products;
    }
}
