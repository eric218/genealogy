package com.dct.swocean.dao;

import com.dct.swocean.entity.PersonStatuss;
import com.dct.swocean.entity.PersonStatussExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonStatussMapper {
    long countByExample(PersonStatussExample example);

    int deleteByExample(PersonStatussExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonStatuss record);

    int insertSelective(PersonStatuss record);

    List<PersonStatuss> selectByExample(PersonStatussExample example);

    PersonStatuss selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonStatuss record, @Param("example") PersonStatussExample example);

    int updateByExample(@Param("record") PersonStatuss record, @Param("example") PersonStatussExample example);

    int updateByPrimaryKeySelective(PersonStatuss record);

    int updateByPrimaryKey(PersonStatuss record);
}