package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNetSlidePics;
import com.dct.swocean.entity.SysNetSlidePicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNetSlidePicsMapper {
    long countByExample(SysNetSlidePicsExample example);

    int deleteByExample(SysNetSlidePicsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNetSlidePics record);

    int insertSelective(SysNetSlidePics record);

    List<SysNetSlidePics> selectByExample(SysNetSlidePicsExample example);

    SysNetSlidePics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNetSlidePics record, @Param("example") SysNetSlidePicsExample example);

    int updateByExample(@Param("record") SysNetSlidePics record, @Param("example") SysNetSlidePicsExample example);

    int updateByPrimaryKeySelective(SysNetSlidePics record);

    int updateByPrimaryKey(SysNetSlidePics record);
}