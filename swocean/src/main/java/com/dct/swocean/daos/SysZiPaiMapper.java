package com.dct.swocean.daos;

import com.dct.swocean.entitys.SysZiPai;
import com.dct.swocean.entitys.SysZiPaiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysZiPaiMapper {
    long countByExample(SysZiPaiExample example);

    int deleteByExample(SysZiPaiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysZiPai record);

    int insertSelective(SysZiPai record);

    List<SysZiPai> selectByExample(SysZiPaiExample example);

    SysZiPai selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysZiPai record, @Param("example") SysZiPaiExample example);

    int updateByExample(@Param("record") SysZiPai record, @Param("example") SysZiPaiExample example);

    int updateByPrimaryKeySelective(SysZiPai record);

    int updateByPrimaryKey(SysZiPai record);
}