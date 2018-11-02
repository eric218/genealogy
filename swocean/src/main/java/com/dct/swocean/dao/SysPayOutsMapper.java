package com.dct.swocean.dao;

import com.dct.swocean.entity.SysPayOuts;
import com.dct.swocean.entity.SysPayOutsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPayOutsMapper {
    long countByExample(SysPayOutsExample example);

    int deleteByExample(SysPayOutsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPayOuts record);

    int insertSelective(SysPayOuts record);

    List<SysPayOuts> selectByExample(SysPayOutsExample example);

    SysPayOuts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPayOuts record, @Param("example") SysPayOutsExample example);

    int updateByExample(@Param("record") SysPayOuts record, @Param("example") SysPayOutsExample example);

    int updateByPrimaryKeySelective(SysPayOuts record);

    int updateByPrimaryKey(SysPayOuts record);
}