package com.lesson12.demo12.oneToMany.controller;

import com.lesson12.demo12.oneToMany.entity.ProductTypeom;
import com.lesson12.demo12.oneToMany.entity.Productom;
import com.lesson12.demo12.oneToMany.repo.ProductTypeomRepo;
import com.lesson12.demo12.oneToMany.repo.ProductomRepo;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title : o2mController </p>
 * <p>Description : todo</p>
 *
 * @author huifer
 * @date 2018/11/05
 */
@Controller
public class o2mController {

    @Autowired
    private ProductomRepo productomRepo;

    @Autowired
    private ProductTypeomRepo productTypeomRepo;


    @GetMapping("/otm")
    @ResponseBody
    public void otm(){
        ProductTypeom type = new ProductTypeom();
        type.setName("类型1");

        Productom product1 = new Productom("产品1");
        Productom product2 = new Productom("产品2");

        type.getProducts().add(product1);
        type.getProducts().add(product2);

        productTypeomRepo.save(type);
        ProductTypeom type2 = new ProductTypeom();
        type2.setName("类型2");
        type2.getProducts().add(product1);
        type2.getProducts().add(product2);
        productTypeomRepo.save(type2);
    }


}
