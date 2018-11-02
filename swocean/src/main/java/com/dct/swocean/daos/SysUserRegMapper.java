package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysUserReg;
import com.dct.swocean.entitys.SysUserRegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRegMapper {
    long countByExample(SysUserRegExample example);

    int deleteByExample(SysUserRegExample example);

    int deleteByPrimaryKey(Integer regId);

    int insert(SysUserReg record);

    int insertSelective(SysUserReg record);

    List<SysUserReg> selectByExample(SysUserRegExample example);

    SysUserReg selectByPrimaryKey(Integer regId);

    int updateByExampleSelective(@Param("record") SysUserReg record, @Param("example") SysUserRegExample example);

    int updateByExample(@Param("record") SysUserReg record, @Param("example") SysUserRegExample example);

    int updateByPrimaryKeySelective(SysUserReg record);

    int updateByPrimaryKey(SysUserReg record);
}