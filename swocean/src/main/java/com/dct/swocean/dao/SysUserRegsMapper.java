package com.dct.swocean.dao;

import com.dct.swocean.entity.SysUserRegs;
import com.dct.swocean.entity.SysUserRegsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRegsMapper {
    long countByExample(SysUserRegsExample example);

    int deleteByExample(SysUserRegsExample example);

    int deleteByPrimaryKey(Integer regId);

    int insert(SysUserRegs record);

    int insertSelective(SysUserRegs record);

    List<SysUserRegs> selectByExample(SysUserRegsExample example);

    SysUserRegs selectByPrimaryKey(Integer regId);

    int updateByExampleSelective(@Param("record") SysUserRegs record, @Param("example") SysUserRegsExample example);

    int updateByExample(@Param("record") SysUserRegs record, @Param("example") SysUserRegsExample example);

    int updateByPrimaryKeySelective(SysUserRegs record);

    int updateByPrimaryKey(SysUserRegs record);
}