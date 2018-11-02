package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysElectroSpectrum;
import com.dct.swocean.entitys.SysElectroSpectrumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysElectroSpectrumMapper {
    long countByExample(SysElectroSpectrumExample example);

    int deleteByExample(SysElectroSpectrumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysElectroSpectrum record);

    int insertSelective(SysElectroSpectrum record);

    List<SysElectroSpectrum> selectByExample(SysElectroSpectrumExample example);

    SysElectroSpectrum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysElectroSpectrum record, @Param("example") SysElectroSpectrumExample example);

    int updateByExample(@Param("record") SysElectroSpectrum record, @Param("example") SysElectroSpectrumExample example);

    int updateByPrimaryKeySelective(SysElectroSpectrum record);

    int updateByPrimaryKey(SysElectroSpectrum record);
}