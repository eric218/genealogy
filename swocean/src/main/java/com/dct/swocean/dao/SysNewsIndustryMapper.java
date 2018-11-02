package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysNewsIndustry;
import com.dct.swocean.entitys.SysNewsIndustryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsIndustryMapper {
    long countByExample(SysNewsIndustryExample example);

    int deleteByExample(SysNewsIndustryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsIndustry record);

    int insertSelective(SysNewsIndustry record);

    List<SysNewsIndustry> selectByExample(SysNewsIndustryExample example);

    SysNewsIndustry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsIndustry record, @Param("example") SysNewsIndustryExample example);

    int updateByExample(@Param("record") SysNewsIndustry record, @Param("example") SysNewsIndustryExample example);

    int updateByPrimaryKeySelective(SysNewsIndustry record);

    int updateByPrimaryKey(SysNewsIndustry record);
}