package com.dct.swocean.dao;

import com.dct.swocean.entity.SysMessages;
import com.dct.swocean.entity.SysMessagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMessagesMapper {
    long countByExample(SysMessagesExample example);

    int deleteByExample(SysMessagesExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysMessages record);

    int insertSelective(SysMessages record);

    List<SysMessages> selectByExample(SysMessagesExample example);

    SysMessages selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysMessages record, @Param("example") SysMessagesExample example);

    int updateByExample(@Param("record") SysMessages record, @Param("example") SysMessagesExample example);

    int updateByPrimaryKeySelective(SysMessages record);

    int updateByPrimaryKey(SysMessages record);
}