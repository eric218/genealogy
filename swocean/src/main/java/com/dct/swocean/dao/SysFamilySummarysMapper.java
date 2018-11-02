package com.dct.swocean.dao;

import com.dct.swocean.entity.SysFamilySummarys;
import com.dct.swocean.entity.SysFamilySummarysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFamilySummarysMapper {
    long countByExample(SysFamilySummarysExample example);

    int deleteByExample(SysFamilySummarysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFamilySummarys record);

    int insertSelective(SysFamilySummarys record);

    List<SysFamilySummarys> selectByExample(SysFamilySummarysExample example);

    SysFamilySummarys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFamilySummarys record, @Param("example") SysFamilySummarysExample example);

    int updateByExample(@Param("record") SysFamilySummarys record, @Param("example") SysFamilySummarysExample example);

    int updateByPrimaryKeySelective(SysFamilySummarys record);

    int updateByPrimaryKey(SysFamilySummarys record);
}