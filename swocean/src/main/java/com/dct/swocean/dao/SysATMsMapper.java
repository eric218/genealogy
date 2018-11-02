package com.dct.swocean.dao;

import com.dct.swocean.entity.SysATMs;
import com.dct.swocean.entity.SysATMsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysATMsMapper {
    long countByExample(SysATMsExample example);

    int deleteByExample(SysATMsExample example);

    int deleteByPrimaryKey(Integer drowId);

    int insert(SysATMs record);

    int insertSelective(SysATMs record);

    List<SysATMs> selectByExample(SysATMsExample example);

    SysATMs selectByPrimaryKey(Integer drowId);

    int updateByExampleSelective(@Param("record") SysATMs record, @Param("example") SysATMsExample example);

    int updateByExample(@Param("record") SysATMs record, @Param("example") SysATMsExample example);

    int updateByPrimaryKeySelective(SysATMs record);

    int updateByPrimaryKey(SysATMs record);
}