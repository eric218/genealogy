package com.dct.swocean.dao;

import com.dct.swocean.entity.SysRecommends;
import com.dct.swocean.entity.SysRecommendsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRecommendsMapper {
    long countByExample(SysRecommendsExample example);

    int deleteByExample(SysRecommendsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRecommends record);

    int insertSelective(SysRecommends record);

    List<SysRecommends> selectByExample(SysRecommendsExample example);

    SysRecommends selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRecommends record, @Param("example") SysRecommendsExample example);

    int updateByExample(@Param("record") SysRecommends record, @Param("example") SysRecommendsExample example);

    int updateByPrimaryKeySelective(SysRecommends record);

    int updateByPrimaryKey(SysRecommends record);
}