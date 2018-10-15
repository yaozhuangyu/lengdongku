package com.jkoss.dao;

import com.jkoss.pojo.ProblemReport;

public interface ProblemReportMapper {
    int deleteByPrimaryKey(Integer ID);

    int insert(ProblemReport record);

    int insertSelective(ProblemReport record);

    ProblemReport selectByPrimaryKey(Integer ID);

    int updateByPrimaryKeySelective(ProblemReport record);

    int updateByPrimaryKey(ProblemReport record);
}