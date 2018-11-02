package com.dct.swocean.dao;

import com.dct.swocean.entity.SysWritings;
import com.dct.swocean.entity.SysWritingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysWritingsMapper {
    long countByExample(SysWritingsExample example);

    int deleteByExample(SysWritingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysWritings record);

    int insertSelective(SysWritings record);

    List<SysWritings> selectByExample(SysWritingsExample example);

    SysWritings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysWritings record, @Param("example") SysWritingsExample example);

    int updateByExample(@Param("record") SysWritings record, @Param("example") SysWritingsExample example);

    int updateByPrimaryKeySelective(SysWritings record);

    int updateByPrimaryKey(SysWritings record);
}