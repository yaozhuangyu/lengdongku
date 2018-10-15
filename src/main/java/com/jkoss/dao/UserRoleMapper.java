package com.jkoss.dao;

import com.jkoss.pojo.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}