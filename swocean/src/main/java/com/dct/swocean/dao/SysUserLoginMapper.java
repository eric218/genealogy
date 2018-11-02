package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysUserLogin;
import com.dct.swocean.entitys.SysUserLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLoginMapper {
    long countByExample(SysUserLoginExample example);

    int deleteByExample(SysUserLoginExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysUserLogin record);

    int insertSelective(SysUserLogin record);

    List<SysUserLogin> selectByExample(SysUserLoginExample example);

    SysUserLogin selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysUserLogin record, @Param("example") SysUserLoginExample example);

    int updateByExample(@Param("record") SysUserLogin record, @Param("example") SysUserLoginExample example);

    int updateByPrimaryKeySelective(SysUserLogin record);

    int updateByPrimaryKey(SysUserLogin record);
}