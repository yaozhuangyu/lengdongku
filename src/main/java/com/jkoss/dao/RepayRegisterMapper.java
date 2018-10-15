package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.RepayRegister;

public interface RepayRegisterMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(RepayRegister record);

    int insertSelective(RepayRegister record);

    RepayRegister selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(RepayRegister record);

    int updateByPrimaryKey(RepayRegister record);
    
    @Select("select * from repayregister")
    List<RepayRegister> findAll();
    @Select("select * from repayregister where CUSTOMERID=#{CUSTOMERID}")
    List<RepayRegister> serepay(@Param("CUSTOMERID") Integer CUSTOMERID);
}