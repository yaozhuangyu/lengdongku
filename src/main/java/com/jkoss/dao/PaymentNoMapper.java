package com.jkoss.dao;

import com.jkoss.pojo.PaymentNo;

public interface PaymentNoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PaymentNo record);

    int insertSelective(PaymentNo record);

    PaymentNo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PaymentNo record);

    int updateByPrimaryKey(PaymentNo record);
}