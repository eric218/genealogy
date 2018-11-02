package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysFamilySummary;
import com.dct.swocean.entitys.SysFamilySummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFamilySummaryMapper {
    long countByExample(SysFamilySummaryExample example);

    int deleteByExample(SysFamilySummaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFamilySummary record);

    int insertSelective(SysFamilySummary record);

    List<SysFamilySummary> selectByExample(SysFamilySummaryExample example);

    SysFamilySummary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFamilySummary record, @Param("example") SysFamilySummaryExample example);

    int updateByExample(@Param("record") SysFamilySummary record, @Param("example") SysFamilySummaryExample example);

    int updateByPrimaryKeySelective(SysFamilySummary record);

    int updateByPrimaryKey(SysFamilySummary record);
}