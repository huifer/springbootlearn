package com.lesson.demo06.controller;

import com.lesson.demo06.engity.Customer;
import com.lesson.demo06.repository.CustomerRepository;
import com.lesson.demo06.repository.CustomerRepositoryInte;
import com.lesson.demo06.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/***
 * 客户控制器
 */
@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerRepositoryInte customerRepositoryInte;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("all")
    public List<Customer> loadCustomers() {
        return customerRepository.findAll();
    }

    /**
     * 查询ID
     *
     * @param id
     * @return
     */
    @GetMapping("get/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        Optional<Customer> byId = customerRepository.findById(id);
        Customer customer = byId.get();
        return customer;
    }


    @GetMapping("get/query/{id}")
    public Customer testqueryKeyWords(@PathVariable("id") Long id) {
        Customer customer = customerRepositoryInte.myFindCustomerById(id);
        return customer;
    }

    @GetMapping("get/query/{id}/{name}")
    public Customer testAndKeyWords(@PathVariable("id") Long id, @PathVariable("name") String name) {

        Customer customer = customerRepositoryInte.myFindAnd(id, name);
        return customer;
    }


    /***
     * 增加客户
     * @param customer
     * @return
     */
    @PostMapping(value = "add")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        Long id = customer.getId();
        return customerService.getCustomerById(id);
    }


}
