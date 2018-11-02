package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysNewsBenefit;
import com.dct.swocean.entitys.SysNewsBenefitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsBenefitMapper {
    long countByExample(SysNewsBenefitExample example);

    int deleteByExample(SysNewsBenefitExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsBenefit record);

    int insertSelective(SysNewsBenefit record);

    List<SysNewsBenefit> selectByExample(SysNewsBenefitExample example);

    SysNewsBenefit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsBenefit record, @Param("example") SysNewsBenefitExample example);

    int updateByExample(@Param("record") SysNewsBenefit record, @Param("example") SysNewsBenefitExample example);

    int updateByPrimaryKeySelective(SysNewsBenefit record);

    int updateByPrimaryKey(SysNewsBenefit record);
}