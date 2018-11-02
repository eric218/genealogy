package com.dct.swocean.dao;

import com.dct.swocean.entity.PersonUploads;
import com.dct.swocean.entity.PersonUploadsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonUploadsMapper {
    long countByExample(PersonUploadsExample example);

    int deleteByExample(PersonUploadsExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonUploads record);

    int insertSelective(PersonUploads record);

    List<PersonUploads> selectByExample(PersonUploadsExample example);

    PersonUploads selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonUploads record, @Param("example") PersonUploadsExample example);

    int updateByExample(@Param("record") PersonUploads record, @Param("example") PersonUploadsExample example);

    int updateByPrimaryKeySelective(PersonUploads record);

    int updateByPrimaryKey(PersonUploads record);
}