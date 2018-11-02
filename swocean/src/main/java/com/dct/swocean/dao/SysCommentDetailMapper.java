package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysCommentDetail;
import com.dct.swocean.entitys.SysCommentDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCommentDetailMapper {
    long countByExample(SysCommentDetailExample example);

    int deleteByExample(SysCommentDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCommentDetail record);

    int insertSelective(SysCommentDetail record);

    List<SysCommentDetail> selectByExample(SysCommentDetailExample example);

    SysCommentDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCommentDetail record, @Param("example") SysCommentDetailExample example);

    int updateByExample(@Param("record") SysCommentDetail record, @Param("example") SysCommentDetailExample example);

    int updateByPrimaryKeySelective(SysCommentDetail record);

    int updateByPrimaryKey(SysCommentDetail record);
}