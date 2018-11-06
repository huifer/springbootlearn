package com.lesson12.demo12.onwWayOneToMany.controller;

import com.lesson12.demo12.onwWayOneToMany.entity.ProductTypeom;
import com.lesson12.demo12.onwWayOneToMany.entity.Productom;
import com.lesson12.demo12.onwWayOneToMany.repo.ProductTypeomRepo;
import com.lesson12.demo12.onwWayOneToMany.repo.ProductomRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    }

    @GetMapping("/otm/find")
    @ResponseBody
    public Optional findone(){
        Optional<ProductTypeom> byId = productTypeomRepo.findById(1L);
        return byId;
    }

    @GetMapping("/otm/findPr")
    @ResponseBody
    public List findAll(){
        List<Productom> all = productomRepo.findAll();
        return all;
    }

}
