package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysNewsCharity;
import com.dct.swocean.entitys.SysNewsCharityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsCharityMapper {
    long countByExample(SysNewsCharityExample example);

    int deleteByExample(SysNewsCharityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsCharity record);

    int insertSelective(SysNewsCharity record);

    List<SysNewsCharity> selectByExample(SysNewsCharityExample example);

    SysNewsCharity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsCharity record, @Param("example") SysNewsCharityExample example);

    int updateByExample(@Param("record") SysNewsCharity record, @Param("example") SysNewsCharityExample example);

    int updateByPrimaryKeySelective(SysNewsCharity record);

    int updateByPrimaryKey(SysNewsCharity record);
}