package com.jkoss.dao;

import com.jkoss.pojo.RoleModuls;

public interface RoleModulsMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(RoleModuls record);

    int insertSelective(RoleModuls record);

    RoleModuls selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(RoleModuls record);

    int updateByPrimaryKey(RoleModuls record);
}