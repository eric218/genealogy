package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysFamily;
import com.dct.swocean.entitys.SysFamilyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFamilyMapper {
    long countByExample(SysFamilyExample example);

    int deleteByExample(SysFamilyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFamily record);

    int insertSelective(SysFamily record);

    List<SysFamily> selectByExample(SysFamilyExample example);

    SysFamily selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFamily record, @Param("example") SysFamilyExample example);

    int updateByExample(@Param("record") SysFamily record, @Param("example") SysFamilyExample example);

    int updateByPrimaryKeySelective(SysFamily record);

    int updateByPrimaryKey(SysFamily record);
}