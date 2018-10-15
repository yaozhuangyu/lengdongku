package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    @Select("select CUSTOMERNAME from customer where ID = #{CUSTOMERID}")
    List<Customer> selectById(@Param("CUSTOMERID")Integer CUSTOMERID);
}