package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysShowPosition;
import com.dct.swocean.entitys.SysShowPositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysShowPositionMapper {
    long countByExample(SysShowPositionExample example);

    int deleteByExample(SysShowPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysShowPosition record);

    int insertSelective(SysShowPosition record);

    List<SysShowPosition> selectByExample(SysShowPositionExample example);

    SysShowPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysShowPosition record, @Param("example") SysShowPositionExample example);

    int updateByExample(@Param("record") SysShowPosition record, @Param("example") SysShowPositionExample example);

    int updateByPrimaryKeySelective(SysShowPosition record);

    int updateByPrimaryKey(SysShowPosition record);
}