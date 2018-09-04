package com.lesson.demo06.repository;

import com.lesson.demo06.engity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = false)
public class CustomerRepository extends SimpleJpaRepository<Customer, Long> {

    @Autowired
    public CustomerRepository(EntityManager em) {
        super(Customer.class, em);
    }


}
