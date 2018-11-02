package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysNewsFamilyVideo;
import com.dct.swocean.entitys.SysNewsFamilyVideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsFamilyVideoMapper {
    long countByExample(SysNewsFamilyVideoExample example);

    int deleteByExample(SysNewsFamilyVideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsFamilyVideo record);

    int insertSelective(SysNewsFamilyVideo record);

    List<SysNewsFamilyVideo> selectByExample(SysNewsFamilyVideoExample example);

    SysNewsFamilyVideo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsFamilyVideo record, @Param("example") SysNewsFamilyVideoExample example);

    int updateByExample(@Param("record") SysNewsFamilyVideo record, @Param("example") SysNewsFamilyVideoExample example);

    int updateByPrimaryKeySelective(SysNewsFamilyVideo record);

    int updateByPrimaryKey(SysNewsFamilyVideo record);
}