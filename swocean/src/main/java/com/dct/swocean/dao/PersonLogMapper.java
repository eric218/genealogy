package com.dct.swocean.dao;

import com.dct.swocean.entitys.PersonLog;
import com.dct.swocean.entitys.PersonLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonLogMapper {
    long countByExample(PersonLogExample example);

    int deleteByExample(PersonLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonLog record);

    int insertSelective(PersonLog record);

    List<PersonLog> selectByExample(PersonLogExample example);

    PersonLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonLog record, @Param("example") PersonLogExample example);

    int updateByExample(@Param("record") PersonLog record, @Param("example") PersonLogExample example);

    int updateByPrimaryKeySelective(PersonLog record);

    int updateByPrimaryKey(PersonLog record);
}