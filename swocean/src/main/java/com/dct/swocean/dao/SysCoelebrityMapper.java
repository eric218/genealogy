package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysCoelebrity;
import com.dct.swocean.entitys.SysCoelebrityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCoelebrityMapper {
    long countByExample(SysCoelebrityExample example);

    int deleteByExample(SysCoelebrityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCoelebrity record);

    int insertSelective(SysCoelebrity record);

    List<SysCoelebrity> selectByExample(SysCoelebrityExample example);

    SysCoelebrity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCoelebrity record, @Param("example") SysCoelebrityExample example);

    int updateByExample(@Param("record") SysCoelebrity record, @Param("example") SysCoelebrityExample example);

    int updateByPrimaryKeySelective(SysCoelebrity record);

    int updateByPrimaryKey(SysCoelebrity record);
}