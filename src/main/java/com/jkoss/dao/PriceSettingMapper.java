package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.Acclf;
import com.jkoss.pojo.PriceSetting;

public interface PriceSettingMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(PriceSetting record);

    int insertSelective(PriceSetting record);

    PriceSetting selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(PriceSetting record);

    int updateByPrimaryKey(PriceSetting record);
    
    @Select("select * from pricesetting")
    @ResultMap("BaseResultMap2")
    List<PriceSetting> lsPs();
    
    List<Acclf> selectLikeByName(String cusname);
}