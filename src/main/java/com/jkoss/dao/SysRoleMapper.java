package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(SysRole record);

    int insertSelective(SysRole record);
    
    @Select("select * from role where ID=#{ID}")
    @ResultMap("com.jkoss.dao.SysRoleMapper.BaseResultMap2")
    SysRole selectByPrimaryKeyWithRt(Integer ID);
    
    @Select("select * from role")
    @ResultMap("com.jkoss.dao.SysRoleMapper.BaseResultMap2")
    List<SysRole> findAll();
    
    SysRole selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}