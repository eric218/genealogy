package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysNet;
import com.dct.swocean.entitys.SysNetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNetMapper {
    long countByExample(SysNetExample example);

    int deleteByExample(SysNetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNet record);

    int insertSelective(SysNet record);

    List<SysNet> selectByExample(SysNetExample example);

    SysNet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNet record, @Param("example") SysNetExample example);

    int updateByExample(@Param("record") SysNet record, @Param("example") SysNetExample example);

    int updateByPrimaryKeySelective(SysNet record);

    int updateByPrimaryKey(SysNet record);
}