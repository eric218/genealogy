package com.dct.swocean.dao;

import com.dct.swocean.entity.SysFamilys;
import com.dct.swocean.entity.SysFamilysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFamilysMapper {
    long countByExample(SysFamilysExample example);

    int deleteByExample(SysFamilysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFamilys record);

    int insertSelective(SysFamilys record);

    List<SysFamilys> selectByExample(SysFamilysExample example);

    SysFamilys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFamilys record, @Param("example") SysFamilysExample example);

    int updateByExample(@Param("record") SysFamilys record, @Param("example") SysFamilysExample example);

    int updateByPrimaryKeySelective(SysFamilys record);

    int updateByPrimaryKey(SysFamilys record);
}