package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysNewsFamous;
import com.dct.swocean.entitys.SysNewsFamousExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsFamousMapper {
    long countByExample(SysNewsFamousExample example);

    int deleteByExample(SysNewsFamousExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsFamous record);

    int insertSelective(SysNewsFamous record);

    List<SysNewsFamous> selectByExample(SysNewsFamousExample example);

    SysNewsFamous selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsFamous record, @Param("example") SysNewsFamousExample example);

    int updateByExample(@Param("record") SysNewsFamous record, @Param("example") SysNewsFamousExample example);

    int updateByPrimaryKeySelective(SysNewsFamous record);

    int updateByPrimaryKey(SysNewsFamous record);
}