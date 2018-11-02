package com.dct.swocean.dao;

import com.dct.swocean.entity.SysUserLogins;
import com.dct.swocean.entity.SysUserLoginsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLoginsMapper {
    long countByExample(SysUserLoginsExample example);

    int deleteByExample(SysUserLoginsExample example);

    int deleteByPrimaryKey(String userId);

    int insert(SysUserLogins record);

    int insertSelective(SysUserLogins record);

    List<SysUserLogins> selectByExample(SysUserLoginsExample example);

    SysUserLogins selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") SysUserLogins record, @Param("example") SysUserLoginsExample example);

    int updateByExample(@Param("record") SysUserLogins record, @Param("example") SysUserLoginsExample example);

    int updateByPrimaryKeySelective(SysUserLogins record);

    int updateByPrimaryKey(SysUserLogins record);
}