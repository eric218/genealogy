package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysUpload;
import com.dct.swocean.entitys.SysUploadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUploadMapper {
    long countByExample(SysUploadExample example);

    int deleteByExample(SysUploadExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysUpload record);

    int insertSelective(SysUpload record);

    List<SysUpload> selectByExample(SysUploadExample example);

    SysUpload selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUpload record, @Param("example") SysUploadExample example);

    int updateByExample(@Param("record") SysUpload record, @Param("example") SysUploadExample example);

    int updateByPrimaryKeySelective(SysUpload record);

    int updateByPrimaryKey(SysUpload record);
}