package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.CoolRegister;

public interface CoolRegisterMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(CoolRegister record);

    int insertSelective(CoolRegister record);

    CoolRegister selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(CoolRegister record);

    int updateByPrimaryKey(CoolRegister record);
    
    @Select("select * from coolregister")
    List<CoolRegister> lsCool();
    
    int updtcool(CoolRegister cr);
    
    @Select("select * from coolregister where CABINETNO like concat(#{nameorid},'%') or CUSTOMERNAME like concat(#{nameorid},'%')")
    List<CoolRegister> queryLikeCool(@Param("nameorid")String nameorid);

}