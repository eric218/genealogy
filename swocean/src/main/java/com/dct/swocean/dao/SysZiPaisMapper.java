package com.dct.swocean.dao;

import com.dct.swocean.entity.SysZiPais;
import com.dct.swocean.entity.SysZiPaisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysZiPaisMapper {
    long countByExample(SysZiPaisExample example);

    int deleteByExample(SysZiPaisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysZiPais record);

    int insertSelective(SysZiPais record);

    List<SysZiPais> selectByExample(SysZiPaisExample example);

    SysZiPais selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysZiPais record, @Param("example") SysZiPaisExample example);

    int updateByExample(@Param("record") SysZiPais record, @Param("example") SysZiPaisExample example);

    int updateByPrimaryKeySelective(SysZiPais record);

    int updateByPrimaryKey(SysZiPais record);
}