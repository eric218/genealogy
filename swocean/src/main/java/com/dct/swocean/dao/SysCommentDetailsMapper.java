package com.dct.swocean.dao;

import com.dct.swocean.entity.SysCommentDetails;
import com.dct.swocean.entity.SysCommentDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCommentDetailsMapper {
    long countByExample(SysCommentDetailsExample example);

    int deleteByExample(SysCommentDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCommentDetails record);

    int insertSelective(SysCommentDetails record);

    List<SysCommentDetails> selectByExample(SysCommentDetailsExample example);

    SysCommentDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCommentDetails record, @Param("example") SysCommentDetailsExample example);

    int updateByExample(@Param("record") SysCommentDetails record, @Param("example") SysCommentDetailsExample example);

    int updateByPrimaryKeySelective(SysCommentDetails record);

    int updateByPrimaryKey(SysCommentDetails record);
}