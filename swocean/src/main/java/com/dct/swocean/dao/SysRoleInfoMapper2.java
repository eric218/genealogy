package com.dct.swocean.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.dct.swocean.entity.SysRoleInfo;

@Mapper
public interface SysRoleInfoMapper2 extends BaseMapper2<SysRoleInfo>
{
//    @Insert("insert into sys_roleinfo(rolename,rolecode) values(#{sysRoleInfo.rolename},#{sysRoleInfo.rolecode})")
//    @Options(useGeneratedKeys = true, keyProperty = "sysRoleInfo.roleid")
//    void insert(@Param("sysRoleInfo") SysRoleInfo sysRoleInfo);
//
//    @Delete("delete from sys_roleinfo where roleid=#{roleid}")
//    void delete(@Param("roleid") int roleid);
//
//    @Update("update sys_roleinfo set rolename=#{sysRoleInfo.rolename} and rolecode=#{sysRoleInfo.rolecode} where roleid=#{sysRoleInfo.roleid}")
//    void update(@Param("sysRoleInfo") SysRoleInfo sysRoleInfo);

    @Select("select * from sys_roleinfo where roleid=#{roleid}")
    SysRoleInfo select(@Param("roleid") int roleid);
    
//
//    @Select("${sql}")
//    List<SysRoleInfo> getAll(@Param("sql") String sql);
//
//    @Select("select * from sys_roleinfo where rolename=#{rolename}")
//    SysRoleInfo selectByRolename(@Param("rolename") String rolename);
    
    @Override
    @Select("${sql}")
    SysRoleInfo findOne(@Param("sql") String sql);
}
