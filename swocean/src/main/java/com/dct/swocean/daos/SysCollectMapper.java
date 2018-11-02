package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysCollect;
import com.dct.swocean.entitys.SysCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCollectMapper {
    long countByExample(SysCollectExample example);

    int deleteByExample(SysCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCollect record);

    int insertSelective(SysCollect record);

    List<SysCollect> selectByExample(SysCollectExample example);

    SysCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCollect record, @Param("example") SysCollectExample example);

    int updateByExample(@Param("record") SysCollect record, @Param("example") SysCollectExample example);

    int updateByPrimaryKeySelective(SysCollect record);

    int updateByPrimaryKey(SysCollect record);
}