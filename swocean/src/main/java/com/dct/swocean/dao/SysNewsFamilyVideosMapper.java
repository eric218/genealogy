package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsFamilyVideos;
import com.dct.swocean.entity.SysNewsFamilyVideosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsFamilyVideosMapper {
    long countByExample(SysNewsFamilyVideosExample example);

    int deleteByExample(SysNewsFamilyVideosExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsFamilyVideos record);

    int insertSelective(SysNewsFamilyVideos record);

    List<SysNewsFamilyVideos> selectByExample(SysNewsFamilyVideosExample example);

    SysNewsFamilyVideos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsFamilyVideos record, @Param("example") SysNewsFamilyVideosExample example);

    int updateByExample(@Param("record") SysNewsFamilyVideos record, @Param("example") SysNewsFamilyVideosExample example);

    int updateByPrimaryKeySelective(SysNewsFamilyVideos record);

    int updateByPrimaryKey(SysNewsFamilyVideos record);
}