package com.lesson12.demo12.onwWayManyToOne.controller;

import com.lesson12.demo12.onwWayManyToOne.entity.Product;
import com.lesson12.demo12.onwWayManyToOne.entity.ProductType;
import com.lesson12.demo12.onwWayManyToOne.repo.ProductRepo;
import com.lesson12.demo12.onwWayManyToOne.repo.ProductTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title : m2oController </p>
 * <p>Description : 多对一 </p>
 *
 * @author huifer
 * @date 2018/11/05
 */
@Controller
public class m2oController {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductTypeRepo productTypeRepo;


    @GetMapping("/m2o")
    @ResponseBody
    public void m2o() {
        ProductType type1 = new ProductType();
        type1.setName("tp1");


        Product product1 = new Product("产品1", null);
        Product product2 = new Product("产品2", type1);

        System.out.println("tp1 保存前" + type1);
        productTypeRepo.save(type1);
        System.out.println("tp1 保存后" + type1);

        productRepo.save(product1);
        productRepo.save(product2);

    }

}
