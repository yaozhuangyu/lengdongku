package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.LocationSetting;

public interface LocationSettingMapper {
	
    int deleteByPrimaryKey(Integer ID);

    int insert(LocationSetting record);

    int insertSelective(LocationSetting record);

    LocationSetting selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(LocationSetting record);

    int updateByPrimaryKey(LocationSetting record);
    
    @Select("select * from locationsetting where AREAID = #{area_id}")
    List<LocationSetting> lslocation(@Param("area_id") int area_id);
    
    @Select("select * from locationsetting")
    @ResultMap("BaseResultMap2")
    List<LocationSetting> lslocation1();
    
    @Select("select CARDNAME from locationsetting where ID = #{CARDID}")
    List<LocationSetting> selectById(@Param("CARDID")Integer CARDID);
   
}