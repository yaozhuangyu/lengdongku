package com.jkoss.dao;

import com.jkoss.pojo.PrepayRegister;

public interface PrepayRegisterMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PrepayRegister record);

    int insertSelective(PrepayRegister record);

    PrepayRegister selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PrepayRegister record);

    int updateByPrimaryKey(PrepayRegister record);
}