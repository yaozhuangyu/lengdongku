package com.jkoss.dao;

import com.jkoss.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}