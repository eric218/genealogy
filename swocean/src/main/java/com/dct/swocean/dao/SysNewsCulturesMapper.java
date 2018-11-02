package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsCultures;
import com.dct.swocean.entity.SysNewsCulturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsCulturesMapper {
    long countByExample(SysNewsCulturesExample example);

    int deleteByExample(SysNewsCulturesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsCultures record);

    int insertSelective(SysNewsCultures record);

    List<SysNewsCultures> selectByExample(SysNewsCulturesExample example);

    SysNewsCultures selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsCultures record, @Param("example") SysNewsCulturesExample example);

    int updateByExample(@Param("record") SysNewsCultures record, @Param("example") SysNewsCulturesExample example);

    int updateByPrimaryKeySelective(SysNewsCultures record);

    int updateByPrimaryKey(SysNewsCultures record);
}