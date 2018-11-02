package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNets;
import com.dct.swocean.entity.SysNetsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNetsMapper {
    long countByExample(SysNetsExample example);

    int deleteByExample(SysNetsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNets record);

    int insertSelective(SysNets record);

    List<SysNets> selectByExample(SysNetsExample example);

    SysNets selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNets record, @Param("example") SysNetsExample example);

    int updateByExample(@Param("record") SysNets record, @Param("example") SysNetsExample example);

    int updateByPrimaryKeySelective(SysNets record);

    int updateByPrimaryKey(SysNets record);
}