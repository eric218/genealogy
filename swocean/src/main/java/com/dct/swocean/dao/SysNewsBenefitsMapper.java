package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsBenefits;
import com.dct.swocean.entity.SysNewsBenefitsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsBenefitsMapper {
    long countByExample(SysNewsBenefitsExample example);

    int deleteByExample(SysNewsBenefitsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsBenefits record);

    int insertSelective(SysNewsBenefits record);

    List<SysNewsBenefits> selectByExample(SysNewsBenefitsExample example);

    SysNewsBenefits selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsBenefits record, @Param("example") SysNewsBenefitsExample example);

    int updateByExample(@Param("record") SysNewsBenefits record, @Param("example") SysNewsBenefitsExample example);

    int updateByPrimaryKeySelective(SysNewsBenefits record);

    int updateByPrimaryKey(SysNewsBenefits record);
}