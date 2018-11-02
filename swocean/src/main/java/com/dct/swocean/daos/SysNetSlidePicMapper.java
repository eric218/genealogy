package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysNetSlidePic;
import com.dct.swocean.entitys.SysNetSlidePicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNetSlidePicMapper {
    long countByExample(SysNetSlidePicExample example);

    int deleteByExample(SysNetSlidePicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNetSlidePic record);

    int insertSelective(SysNetSlidePic record);

    List<SysNetSlidePic> selectByExample(SysNetSlidePicExample example);

    SysNetSlidePic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNetSlidePic record, @Param("example") SysNetSlidePicExample example);

    int updateByExample(@Param("record") SysNetSlidePic record, @Param("example") SysNetSlidePicExample example);

    int updateByPrimaryKeySelective(SysNetSlidePic record);

    int updateByPrimaryKey(SysNetSlidePic record);
}