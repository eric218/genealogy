package com.dct.swocean.dao;

import com.dct.swocean.entity.SysRegions;
import com.dct.swocean.entity.SysRegionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRegionsMapper {
    long countByExample(SysRegionsExample example);

    int deleteByExample(SysRegionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRegions record);

    int insertSelective(SysRegions record);

    List<SysRegions> selectByExample(SysRegionsExample example);

    SysRegions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRegions record, @Param("example") SysRegionsExample example);

    int updateByExample(@Param("record") SysRegions record, @Param("example") SysRegionsExample example);

    int updateByPrimaryKeySelective(SysRegions record);

    int updateByPrimaryKey(SysRegions record);
}