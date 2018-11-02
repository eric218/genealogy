package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysConstant;
import com.dct.swocean.entitys.SysConstantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConstantMapper {
    long countByExample(SysConstantExample example);

    int deleteByExample(SysConstantExample example);

    int insert(SysConstant record);

    int insertSelective(SysConstant record);

    List<SysConstant> selectByExample(SysConstantExample example);

    int updateByExampleSelective(@Param("record") SysConstant record, @Param("example") SysConstantExample example);

    int updateByExample(@Param("record") SysConstant record, @Param("example") SysConstantExample example);
}