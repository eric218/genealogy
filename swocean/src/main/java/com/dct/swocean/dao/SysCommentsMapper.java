package com.dct.swocean.dao;

import com.dct.swocean.entity.SysComments;
import com.dct.swocean.entity.SysCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCommentsMapper {
    long countByExample(SysCommentsExample example);

    int deleteByExample(SysCommentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysComments record);

    int insertSelective(SysComments record);

    List<SysComments> selectByExample(SysCommentsExample example);

    SysComments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysComments record, @Param("example") SysCommentsExample example);

    int updateByExample(@Param("record") SysComments record, @Param("example") SysCommentsExample example);

    int updateByPrimaryKeySelective(SysComments record);

    int updateByPrimaryKey(SysComments record);
}