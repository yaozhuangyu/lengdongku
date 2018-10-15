package com.jkoss.dao;

import com.jkoss.pojo.MarkTable;

public interface MarkTableMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(MarkTable record);

    int insertSelective(MarkTable record);

    MarkTable selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(MarkTable record);

    int updateByPrimaryKey(MarkTable record);
}