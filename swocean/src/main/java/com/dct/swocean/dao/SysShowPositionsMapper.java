package com.dct.swocean.dao;

import com.dct.swocean.entity.SysShowPositions;
import com.dct.swocean.entity.SysShowPositionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysShowPositionsMapper {
    long countByExample(SysShowPositionsExample example);

    int deleteByExample(SysShowPositionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysShowPositions record);

    int insertSelective(SysShowPositions record);

    List<SysShowPositions> selectByExample(SysShowPositionsExample example);

    SysShowPositions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysShowPositions record, @Param("example") SysShowPositionsExample example);

    int updateByExample(@Param("record") SysShowPositions record, @Param("example") SysShowPositionsExample example);

    int updateByPrimaryKeySelective(SysShowPositions record);

    int updateByPrimaryKey(SysShowPositions record);
}