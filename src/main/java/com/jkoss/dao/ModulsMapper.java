package com.jkoss.dao;

import com.jkoss.pojo.Moduls;

public interface ModulsMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Moduls record);

    int insertSelective(Moduls record);

    Moduls selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Moduls record);

    int updateByPrimaryKey(Moduls record);
}