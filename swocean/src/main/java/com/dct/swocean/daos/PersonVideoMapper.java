package com.dct.swocean.daos;

import com.dct.swocean.entitys.PersonVideo;
import com.dct.swocean.entitys.PersonVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonVideoMapper {
    long countByExample(PersonVideoExample example);

    int deleteByExample(PersonVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonVideo record);

    int insertSelective(PersonVideo record);

    List<PersonVideo> selectByExample(PersonVideoExample example);

    PersonVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonVideo record, @Param("example") PersonVideoExample example);

    int updateByExample(@Param("record") PersonVideo record, @Param("example") PersonVideoExample example);

    int updateByPrimaryKeySelective(PersonVideo record);

    int updateByPrimaryKey(PersonVideo record);
}