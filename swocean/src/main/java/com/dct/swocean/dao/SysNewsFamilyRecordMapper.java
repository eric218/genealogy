package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysNewsFamilyRecord;
import com.dct.swocean.entitys.SysNewsFamilyRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsFamilyRecordMapper {
    long countByExample(SysNewsFamilyRecordExample example);

    int deleteByExample(SysNewsFamilyRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsFamilyRecord record);

    int insertSelective(SysNewsFamilyRecord record);

    List<SysNewsFamilyRecord> selectByExample(SysNewsFamilyRecordExample example);

    SysNewsFamilyRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsFamilyRecord record, @Param("example") SysNewsFamilyRecordExample example);

    int updateByExample(@Param("record") SysNewsFamilyRecord record, @Param("example") SysNewsFamilyRecordExample example);

    int updateByPrimaryKeySelective(SysNewsFamilyRecord record);

    int updateByPrimaryKey(SysNewsFamilyRecord record);
}