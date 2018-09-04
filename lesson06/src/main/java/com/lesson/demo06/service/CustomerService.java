package com.lesson.demo06.service;

import com.lesson.demo06.engity.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/***
 * 客户服务
 */
@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    /***
     * 增加一个客户
     * @param customer
     */
    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

}
