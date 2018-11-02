package com.dct.swocean.dao;

import com.dct.swocean.entity.PersonPhotos;
import com.dct.swocean.entity.PersonPhotosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonPhotosMapper {
    long countByExample(PersonPhotosExample example);

    int deleteByExample(PersonPhotosExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonPhotos record);

    int insertSelective(PersonPhotos record);

    List<PersonPhotos> selectByExample(PersonPhotosExample example);

    PersonPhotos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonPhotos record, @Param("example") PersonPhotosExample example);

    int updateByExample(@Param("record") PersonPhotos record, @Param("example") PersonPhotosExample example);

    int updateByPrimaryKeySelective(PersonPhotos record);

    int updateByPrimaryKey(PersonPhotos record);
}