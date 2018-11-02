package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysWriting;
import com.dct.swocean.entitys.SysWritingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysWritingMapper {
    long countByExample(SysWritingExample example);

    int deleteByExample(SysWritingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysWriting record);

    int insertSelective(SysWriting record);

    List<SysWriting> selectByExample(SysWritingExample example);

    SysWriting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysWriting record, @Param("example") SysWritingExample example);

    int updateByExample(@Param("record") SysWriting record, @Param("example") SysWritingExample example);

    int updateByPrimaryKeySelective(SysWriting record);

    int updateByPrimaryKey(SysWriting record);
}