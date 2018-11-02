package com.dct.swocean.daos;

import com.dct.swocean.entitys.PersonUpload;
import com.dct.swocean.entitys.PersonUploadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonUploadMapper {
    long countByExample(PersonUploadExample example);

    int deleteByExample(PersonUploadExample example);

    int deleteByPrimaryKey(String id);

    int insert(PersonUpload record);

    int insertSelective(PersonUpload record);

    List<PersonUpload> selectByExample(PersonUploadExample example);

    PersonUpload selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PersonUpload record, @Param("example") PersonUploadExample example);

    int updateByExample(@Param("record") PersonUpload record, @Param("example") PersonUploadExample example);

    int updateByPrimaryKeySelective(PersonUpload record);

    int updateByPrimaryKey(PersonUpload record);
}