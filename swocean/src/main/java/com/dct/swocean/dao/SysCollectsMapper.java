package com.dct.swocean.dao;

import com.dct.swocean.entity.SysCollects;
import com.dct.swocean.entity.SysCollectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCollectsMapper {
    long countByExample(SysCollectsExample example);

    int deleteByExample(SysCollectsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCollects record);

    int insertSelective(SysCollects record);

    List<SysCollects> selectByExample(SysCollectsExample example);

    SysCollects selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCollects record, @Param("example") SysCollectsExample example);

    int updateByExample(@Param("record") SysCollects record, @Param("example") SysCollectsExample example);

    int updateByPrimaryKeySelective(SysCollects record);

    int updateByPrimaryKey(SysCollects record);
}