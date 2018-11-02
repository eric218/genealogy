package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsTongPus;
import com.dct.swocean.entity.SysNewsTongPusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsTongPusMapper {
    long countByExample(SysNewsTongPusExample example);

    int deleteByExample(SysNewsTongPusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsTongPus record);

    int insertSelective(SysNewsTongPus record);

    List<SysNewsTongPus> selectByExample(SysNewsTongPusExample example);

    SysNewsTongPus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsTongPus record, @Param("example") SysNewsTongPusExample example);

    int updateByExample(@Param("record") SysNewsTongPus record, @Param("example") SysNewsTongPusExample example);

    int updateByPrimaryKeySelective(SysNewsTongPus record);

    int updateByPrimaryKey(SysNewsTongPus record);
}