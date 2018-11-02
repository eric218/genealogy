package com.dct.swocean.dao;

import com.dct.swocean.entity.SysNewsCharitys;
import com.dct.swocean.entity.SysNewsCharitysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysNewsCharitysMapper {
    long countByExample(SysNewsCharitysExample example);

    int deleteByExample(SysNewsCharitysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysNewsCharitys record);

    int insertSelective(SysNewsCharitys record);

    List<SysNewsCharitys> selectByExample(SysNewsCharitysExample example);

    SysNewsCharitys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysNewsCharitys record, @Param("example") SysNewsCharitysExample example);

    int updateByExample(@Param("record") SysNewsCharitys record, @Param("example") SysNewsCharitysExample example);

    int updateByPrimaryKeySelective(SysNewsCharitys record);

    int updateByPrimaryKey(SysNewsCharitys record);
}