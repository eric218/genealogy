package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysATM;
import com.dct.swocean.entitys.SysATMExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysATMMapper {
    long countByExample(SysATMExample example);

    int deleteByExample(SysATMExample example);

    int deleteByPrimaryKey(Integer drowId);

    int insert(SysATM record);

    int insertSelective(SysATM record);

    List<SysATM> selectByExample(SysATMExample example);

    SysATM selectByPrimaryKey(Integer drowId);

    int updateByExampleSelective(@Param("record") SysATM record, @Param("example") SysATMExample example);

    int updateByExample(@Param("record") SysATM record, @Param("example") SysATMExample example);

    int updateByPrimaryKeySelective(SysATM record);

    int updateByPrimaryKey(SysATM record);
}