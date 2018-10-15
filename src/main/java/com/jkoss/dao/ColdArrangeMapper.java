package com.jkoss.dao;

import com.jkoss.pojo.ColdArrange;

public interface ColdArrangeMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ColdArrange record);

    int insertSelective(ColdArrange record);

    ColdArrange selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ColdArrange record);

    int updateByPrimaryKey(ColdArrange record);
}