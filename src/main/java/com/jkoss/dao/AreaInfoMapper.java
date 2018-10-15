package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.AreaInfo;

public interface AreaInfoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(AreaInfo record);

    int insertSelective(AreaInfo record);

    AreaInfo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(AreaInfo record);

    int updateByPrimaryKey(AreaInfo record);
    
    @Select("select * from areainfo")
    List<AreaInfo> lsarea();
    
    @Select("select AREANAME from areainfo where ID = #{AREAID}")
    List<AreaInfo> selectById(@Param("AREAID")Integer AREAID);
}