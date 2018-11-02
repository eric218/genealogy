package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysComment;
import com.dct.swocean.entitys.SysCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCommentMapper {
    long countByExample(SysCommentExample example);

    int deleteByExample(SysCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysComment record);

    int insertSelective(SysComment record);

    List<SysComment> selectByExample(SysCommentExample example);

    SysComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysComment record, @Param("example") SysCommentExample example);

    int updateByExample(@Param("record") SysComment record, @Param("example") SysCommentExample example);

    int updateByPrimaryKeySelective(SysComment record);

    int updateByPrimaryKey(SysComment record);
}