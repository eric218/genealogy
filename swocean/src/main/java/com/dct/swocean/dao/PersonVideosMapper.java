package com.dct.swocean.dao;

import com.dct.swocean.entity.PersonVideos;
import com.dct.swocean.entity.PersonVideosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonVideosMapper {
    long countByExample(PersonVideosExample example);

    int deleteByExample(PersonVideosExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonVideos record);

    int insertSelective(PersonVideos record);

    List<PersonVideos> selectByExample(PersonVideosExample example);

    PersonVideos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonVideos record, @Param("example") PersonVideosExample example);

    int updateByExample(@Param("record") PersonVideos record, @Param("example") PersonVideosExample example);

    int updateByPrimaryKeySelective(PersonVideos record);

    int updateByPrimaryKey(PersonVideos record);
}