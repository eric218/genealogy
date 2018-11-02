package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysNewsCulture;
import com.dct.swocean.entitys.SysNewsCultureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsCultureMapper {
    long countByExample(SysNewsCultureExample example);

    int deleteByExample(SysNewsCultureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsCulture record);

    int insertSelective(SysNewsCulture record);

    List<SysNewsCulture> selectByExample(SysNewsCultureExample example);

    SysNewsCulture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsCulture record, @Param("example") SysNewsCultureExample example);

    int updateByExample(@Param("record") SysNewsCulture record, @Param("example") SysNewsCultureExample example);

    int updateByPrimaryKeySelective(SysNewsCulture record);

    int updateByPrimaryKey(SysNewsCulture record);
}