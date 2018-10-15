package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jkoss.pojo.CabinatSetting;

public interface CabinatSettingMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(CabinatSetting record);

    int insertSelective(CabinatSetting record);

    CabinatSetting selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(CabinatSetting record);

    int updateByPrimaryKey(CabinatSetting record);
    
    @Select("select * from cabinatsetting")
    List<CabinatSetting> lscab();
    
    @Select("select * from cabinatsetting where CARDID =#{loc_id}")
    List<CabinatSetting> lsCabById(@Param("loc_id")int loc_id);
    
    @Insert("insert into cabinatsetting(SERIALNO,LOCATION,CABINATENAME,CAPACITY,STATE) "
    		+ "values (#{cab.SERIALNO},#{cab.LOCATION},#{cab.CABINATENAME},#{cab.CAPACITY},#{cab.STATE})")
    int addcab(@Param("cab")CabinatSetting cab);
    
    @Delete("delete from cabinatsetting where ID = #{cab_id}")
    int delcab(@Param("cab_id") String cab_id);
    
    @Select("select * from cabinatsetting where ID = #{cab_id}")
    CabinatSetting onecab(@Param("cab_id") String cab_id);
    
    int updtcab(CabinatSetting cab);
    
    @Select("select * from cabinatsetting where CARDID =#{ID}")
    List<CabinatSetting> selectByID(@Param("ID")int ID);
    
    @Update("update cabinatsetting set STATE = 0 where CARDID = #{loc_id}")
    int updall(@Param("loc_id")int loc_id);
    
    @Update("update cabinatsetting set STATE = 1 where ID = #{cab_id}")
    int cgstate(@Param("cab_id")int cab_id);
    
    @Select("select CABINATENAME from cabinatsetting where ID = #{CABINID}")
    List<CabinatSetting> selectById(@Param("CABINID")Integer CABINID);
    
}