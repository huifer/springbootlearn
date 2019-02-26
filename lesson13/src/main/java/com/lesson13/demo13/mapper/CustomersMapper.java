package com.lesson13.demo13.mapper;

import com.example.demo.model.Customers;

public interface CustomersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Customers record);

    int insertSelective(Customers record);

    Customers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Customers record);

    int updateByPrimaryKey(Customers record);
}
