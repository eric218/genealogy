package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysNetDescribe;
import com.dct.swocean.entitys.SysNetDescribeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNetDescribeMapper {
    long countByExample(SysNetDescribeExample example);

    int deleteByExample(SysNetDescribeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNetDescribe record);

    int insertSelective(SysNetDescribe record);

    List<SysNetDescribe> selectByExample(SysNetDescribeExample example);

    SysNetDescribe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNetDescribe record, @Param("example") SysNetDescribeExample example);

    int updateByExample(@Param("record") SysNetDescribe record, @Param("example") SysNetDescribeExample example);

    int updateByPrimaryKeySelective(SysNetDescribe record);

    int updateByPrimaryKey(SysNetDescribe record);
}