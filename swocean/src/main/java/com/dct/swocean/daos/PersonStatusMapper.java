package com.dct.swocean.daos;

import com.dct.swocean.entitys.PersonStatus;
import com.dct.swocean.entitys.PersonStatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonStatusMapper {
    long countByExample(PersonStatusExample example);

    int deleteByExample(PersonStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PersonStatus record);

    int insertSelective(PersonStatus record);

    List<PersonStatus> selectByExample(PersonStatusExample example);

    PersonStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PersonStatus record, @Param("example") PersonStatusExample example);

    int updateByExample(@Param("record") PersonStatus record, @Param("example") PersonStatusExample example);

    int updateByPrimaryKeySelective(PersonStatus record);

    int updateByPrimaryKey(PersonStatus record);
}