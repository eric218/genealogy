package com.dct.swocean.dao;

import com.dct.swocean.entity.SysConstants;
import com.dct.swocean.entity.SysConstantsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysConstantsMapper {
    long countByExample(SysConstantsExample example);

    int deleteByExample(SysConstantsExample example);

    int insert(SysConstants record);

    int insertSelective(SysConstants record);

    List<SysConstants> selectByExample(SysConstantsExample example);

    int updateByExampleSelective(@Param("record") SysConstants record, @Param("example") SysConstantsExample example);

    int updateByExample(@Param("record") SysConstants record, @Param("example") SysConstantsExample example);
}