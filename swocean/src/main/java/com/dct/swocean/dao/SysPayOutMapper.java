package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysPayOut;
import com.dct.swocean.entitys.SysPayOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPayOutMapper {
    long countByExample(SysPayOutExample example);

    int deleteByExample(SysPayOutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPayOut record);

    int insertSelective(SysPayOut record);

    List<SysPayOut> selectByExample(SysPayOutExample example);

    SysPayOut selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPayOut record, @Param("example") SysPayOutExample example);

    int updateByExample(@Param("record") SysPayOut record, @Param("example") SysPayOutExample example);

    int updateByPrimaryKeySelective(SysPayOut record);

    int updateByPrimaryKey(SysPayOut record);
}