package com.dct.swocean.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.dct.swocean.entity.LogSystem;

@Mapper
public interface LogSystemMapper
{
    @Insert(value = {
            "insert into log_system (system_id,addby,add_time,type,table_code,table_name,login_id,description,remark,object_id) valuse"
            + " (#{logSystem.system_id},#{logSystem.addby},#{logSystem.add_time},#{logSystem.type},#{logSystem.table_code},"
            + "#{logSystem.table_name},#{logSystem.login_id},#{logSystem.description},#{logSystem.remark},#{logSystem.object_id)" })
    @Options(useGeneratedKeys = true, keyProperty = "logSystem.id")
    public int addLogSystem(@Param("logSystem") LogSystem logSystem);
    
    @Select(value = { "select * from log_system #{where}" })
    public List<LogSystem> queryLogSystem(String where);
}
