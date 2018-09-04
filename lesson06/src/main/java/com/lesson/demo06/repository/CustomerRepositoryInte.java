package com.lesson.demo06.repository;

import com.lesson.demo06.engity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepositoryInte extends JpaRepository<Customer, Long> {
    @Query("from Customer  c where c.id=:id")
    Customer myFindCustomerById(@Param("id") Long id);


    @Query("from Customer  c where c.id=?1 or c.name=?2")
    Customer myFindAnd(@Param("id") Long id, @Param("name") String name);
}
