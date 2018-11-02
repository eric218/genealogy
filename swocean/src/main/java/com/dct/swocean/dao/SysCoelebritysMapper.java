package com.dct.swocean.dao;

import com.dct.swocean.entity.SysCoelebritys;
import com.dct.swocean.entity.SysCoelebritysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCoelebritysMapper {
    long countByExample(SysCoelebritysExample example);

    int deleteByExample(SysCoelebritysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCoelebritys record);

    int insertSelective(SysCoelebritys record);

    List<SysCoelebritys> selectByExample(SysCoelebritysExample example);

    SysCoelebritys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCoelebritys record, @Param("example") SysCoelebritysExample example);

    int updateByExample(@Param("record") SysCoelebritys record, @Param("example") SysCoelebritysExample example);

    int updateByPrimaryKeySelective(SysCoelebritys record);

    int updateByPrimaryKey(SysCoelebritys record);
}