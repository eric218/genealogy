package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNetDescribes;
import com.dct.swocean.entity.SysNetDescribesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNetDescribesMapper {
    long countByExample(SysNetDescribesExample example);

    int deleteByExample(SysNetDescribesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNetDescribes record);

    int insertSelective(SysNetDescribes record);

    List<SysNetDescribes> selectByExample(SysNetDescribesExample example);

    SysNetDescribes selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNetDescribes record, @Param("example") SysNetDescribesExample example);

    int updateByExample(@Param("record") SysNetDescribes record, @Param("example") SysNetDescribesExample example);

    int updateByPrimaryKeySelective(SysNetDescribes record);

    int updateByPrimaryKey(SysNetDescribes record);
}