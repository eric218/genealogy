package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsIndustrys;
import com.dct.swocean.entity.SysNewsIndustrysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsIndustrysMapper {
    long countByExample(SysNewsIndustrysExample example);

    int deleteByExample(SysNewsIndustrysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsIndustrys record);

    int insertSelective(SysNewsIndustrys record);

    List<SysNewsIndustrys> selectByExample(SysNewsIndustrysExample example);

    SysNewsIndustrys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsIndustrys record, @Param("example") SysNewsIndustrysExample example);

    int updateByExample(@Param("record") SysNewsIndustrys record, @Param("example") SysNewsIndustrysExample example);

    int updateByPrimaryKeySelective(SysNewsIndustrys record);

    int updateByPrimaryKey(SysNewsIndustrys record);
}