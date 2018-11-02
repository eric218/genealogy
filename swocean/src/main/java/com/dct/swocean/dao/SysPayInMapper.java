package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysPayIn;
import com.dct.swocean.entitys.SysPayInExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPayInMapper {
    long countByExample(SysPayInExample example);

    int deleteByExample(SysPayInExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPayIn record);

    int insertSelective(SysPayIn record);

    List<SysPayIn> selectByExample(SysPayInExample example);

    SysPayIn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPayIn record, @Param("example") SysPayInExample example);

    int updateByExample(@Param("record") SysPayIn record, @Param("example") SysPayInExample example);

    int updateByPrimaryKeySelective(SysPayIn record);

    int updateByPrimaryKey(SysPayIn record);
}