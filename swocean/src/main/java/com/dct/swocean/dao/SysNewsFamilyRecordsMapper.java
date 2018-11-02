package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsFamilyRecords;
import com.dct.swocean.entity.SysNewsFamilyRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsFamilyRecordsMapper {
    long countByExample(SysNewsFamilyRecordsExample example);

    int deleteByExample(SysNewsFamilyRecordsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsFamilyRecords record);

    int insertSelective(SysNewsFamilyRecords record);

    List<SysNewsFamilyRecords> selectByExample(SysNewsFamilyRecordsExample example);

    SysNewsFamilyRecords selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsFamilyRecords record, @Param("example") SysNewsFamilyRecordsExample example);

    int updateByExample(@Param("record") SysNewsFamilyRecords record, @Param("example") SysNewsFamilyRecordsExample example);

    int updateByPrimaryKeySelective(SysNewsFamilyRecords record);

    int updateByPrimaryKey(SysNewsFamilyRecords record);
}