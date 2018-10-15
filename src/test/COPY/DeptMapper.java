package com.jkoss.dao;

import com.jkoss.pojo.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}