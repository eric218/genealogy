package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsFamouss;
import com.dct.swocean.entity.SysNewsFamoussExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsFamoussMapper {
    long countByExample(SysNewsFamoussExample example);

    int deleteByExample(SysNewsFamoussExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsFamouss record);

    int insertSelective(SysNewsFamouss record);

    List<SysNewsFamouss> selectByExample(SysNewsFamoussExample example);

    SysNewsFamouss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsFamouss record, @Param("example") SysNewsFamoussExample example);

    int updateByExample(@Param("record") SysNewsFamouss record, @Param("example") SysNewsFamoussExample example);

    int updateByPrimaryKeySelective(SysNewsFamouss record);

    int updateByPrimaryKey(SysNewsFamouss record);
}