package com.dct.swocean.dao;

import com.dct.swocean.entity.SysUploads;
import com.dct.swocean.entity.SysUploadsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUploadsMapper {
    long countByExample(SysUploadsExample example);

    int deleteByExample(SysUploadsExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUploads record);

    int insertSelective(SysUploads record);

    List<SysUploads> selectByExample(SysUploadsExample example);

    SysUploads selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUploads record, @Param("example") SysUploadsExample example);

    int updateByExample(@Param("record") SysUploads record, @Param("example") SysUploadsExample example);

    int updateByPrimaryKeySelective(SysUploads record);

    int updateByPrimaryKey(SysUploads record);
}