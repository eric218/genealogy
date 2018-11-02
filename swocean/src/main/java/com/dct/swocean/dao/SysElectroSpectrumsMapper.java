package com.dct.swocean.dao;

import com.dct.swocean.entity.SysElectroSpectrums;
import com.dct.swocean.entity.SysElectroSpectrumsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysElectroSpectrumsMapper {
    long countByExample(SysElectroSpectrumsExample example);

    int deleteByExample(SysElectroSpectrumsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysElectroSpectrums record);

    int insertSelective(SysElectroSpectrums record);

    List<SysElectroSpectrums> selectByExample(SysElectroSpectrumsExample example);

    SysElectroSpectrums selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysElectroSpectrums record, @Param("example") SysElectroSpectrumsExample example);

    int updateByExample(@Param("record") SysElectroSpectrums record, @Param("example") SysElectroSpectrumsExample example);

    int updateByPrimaryKeySelective(SysElectroSpectrums record);

    int updateByPrimaryKey(SysElectroSpectrums record);
}