package com.jkoss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jkoss.pojo.FruitCategory;

public interface FruitCategoryMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(FruitCategory record);

    int insertSelective(FruitCategory record);

    FruitCategory selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(FruitCategory record);

    int updateByPrimaryKey(FruitCategory record);
    
    @Select("select CATENAME from fruitcategory where ID = #{FRUITCATEGORYID}")
    List<FruitCategory> selectById(@Param("FRUITCATEGORYID")Integer FRUITCATEGORYID);
}