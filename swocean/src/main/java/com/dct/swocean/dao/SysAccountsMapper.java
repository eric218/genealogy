package com.dct.swocean.dao;

import com.dct.swocean.entity.SysAccounts;
import com.dct.swocean.entity.SysAccountsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountsMapper {
    long countByExample(SysAccountsExample example);

    int deleteByExample(SysAccountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAccounts record);

    int insertSelective(SysAccounts record);

    List<SysAccounts> selectByExample(SysAccountsExample example);

    SysAccounts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAccounts record, @Param("example") SysAccountsExample example);

    int updateByExample(@Param("record") SysAccounts record, @Param("example") SysAccountsExample example);

    int updateByPrimaryKeySelective(SysAccounts record);

    int updateByPrimaryKey(SysAccounts record);
}