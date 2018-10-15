package com.jkoss.dao;

import com.jkoss.pojo.LogInfo;

public interface LogInfoMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(LogInfo record);

    int insertSelective(LogInfo record);

    LogInfo selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(LogInfo record);

    int updateByPrimaryKey(LogInfo record);
}