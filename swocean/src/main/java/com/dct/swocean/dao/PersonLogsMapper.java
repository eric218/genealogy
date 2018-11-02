package com.dct.swocean.dao;

import com.dct.swocean.entity.PersonLogs;
import com.dct.swocean.entity.PersonLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonLogsMapper {
    long countByExample(PersonLogsExample example);

    int deleteByExample(PersonLogsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonLogs record);

    int insertSelective(PersonLogs record);

    List<PersonLogs> selectByExample(PersonLogsExample example);

    PersonLogs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonLogs record, @Param("example") PersonLogsExample example);

    int updateByExample(@Param("record") PersonLogs record, @Param("example") PersonLogsExample example);

    int updateByPrimaryKeySelective(PersonLogs record);

    int updateByPrimaryKey(PersonLogs record);
}