package com.jkoss.dao;

import com.jkoss.pojo.CustomerPayRecords;

public interface CustomerPayRecordsMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(CustomerPayRecords record);

    int insertSelective(CustomerPayRecords record);

    CustomerPayRecords selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(CustomerPayRecords record);

    int updateByPrimaryKey(CustomerPayRecords record);
}