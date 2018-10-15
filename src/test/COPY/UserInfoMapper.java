package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    @Select("select * from userinfo where name=#{name}")
    UserInfo selectByName(String name) ;
    
    @Select("select * from userinfo")
    List<UserInfo> selectByAll();
}