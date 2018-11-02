package com.dct.swocean.dao;

import com.dct.swocean.entitys.SysRecommend;
import com.dct.swocean.entitys.SysRecommendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRecommendMapper {
    long countByExample(SysRecommendExample example);

    int deleteByExample(SysRecommendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRecommend record);

    int insertSelective(SysRecommend record);

    List<SysRecommend> selectByExample(SysRecommendExample example);

    SysRecommend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRecommend record, @Param("example") SysRecommendExample example);

    int updateByExample(@Param("record") SysRecommend record, @Param("example") SysRecommendExample example);

    int updateByPrimaryKeySelective(SysRecommend record);

    int updateByPrimaryKey(SysRecommend record);
}