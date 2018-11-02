package com.dct.swocean.daos;

import com.dct.swocean.entitys.PersonPhoto;
import com.dct.swocean.entitys.PersonPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonPhotoMapper {
    long countByExample(PersonPhotoExample example);

    int deleteByExample(PersonPhotoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonPhoto record);

    int insertSelective(PersonPhoto record);

    List<PersonPhoto> selectByExample(PersonPhotoExample example);

    PersonPhoto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonPhoto record, @Param("example") PersonPhotoExample example);

    int updateByExample(@Param("record") PersonPhoto record, @Param("example") PersonPhotoExample example);

    int updateByPrimaryKeySelective(PersonPhoto record);

    int updateByPrimaryKey(PersonPhoto record);
}