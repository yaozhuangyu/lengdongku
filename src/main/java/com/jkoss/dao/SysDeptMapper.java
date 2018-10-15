package com.jkoss.dao;

import com.jkoss.pojo.SysDept;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
}