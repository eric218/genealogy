package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysNewsTongPu;
import com.dct.swocean.entitys.SysNewsTongPuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsTongPuMapper {
    long countByExample(SysNewsTongPuExample example);

    int deleteByExample(SysNewsTongPuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsTongPu record);

    int insertSelective(SysNewsTongPu record);

    List<SysNewsTongPu> selectByExample(SysNewsTongPuExample example);

    SysNewsTongPu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsTongPu record, @Param("example") SysNewsTongPuExample example);

    int updateByExample(@Param("record") SysNewsTongPu record, @Param("example") SysNewsTongPuExample example);

    int updateByPrimaryKeySelective(SysNewsTongPu record);

    int updateByPrimaryKey(SysNewsTongPu record);
}