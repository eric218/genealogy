package com.dct.swocean.dao;

import com.dct.swocean.entity.SysPayIns;
import com.dct.swocean.entity.SysPayInsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPayInsMapper {
    long countByExample(SysPayInsExample example);

    int deleteByExample(SysPayInsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysPayIns record);

    int insertSelective(SysPayIns record);

    List<SysPayIns> selectByExample(SysPayInsExample example);

    SysPayIns selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysPayIns record, @Param("example") SysPayInsExample example);

    int updateByExample(@Param("record") SysPayIns record, @Param("example") SysPayInsExample example);

    int updateByPrimaryKeySelective(SysPayIns record);

    int updateByPrimaryKey(SysPayIns record);
}