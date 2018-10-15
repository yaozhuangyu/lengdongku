package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    @Select("select * from userinfo where name=#{name}")
    @ResultMap("com.jkoss.dao.SysUserMapper.BaseResultMap2")
    SysUser selectByName(String name) ;
    
    @Select("select * from userinfo")
    List<SysUser> selectByAll();
    
    //找回密码
    @Select("select * from userinfo where mobile = #{phone}")
    SysUser queryUserByPhone(@Param("phone") String phone);
   // @Select("update userinfo set password = #{password} where mobile = #{phone}")
    int updPass(@Param("phone") String phone,@Param("password") String password);
}