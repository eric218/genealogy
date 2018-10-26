package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.entity.SysRoleInfo;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.dbhelper.DeleteSQL;
import com.dct.swocean.util.dbhelper.InsertSQL;
import com.dct.swocean.util.dbhelper.SelectSQL;
import com.dct.swocean.util.dbhelper.UpdateSQL;

public interface SysRoleInfoService
{
    public void insert(InsertSQL insertSQL);

    public void delete(DeleteSQL deleteSQL);
    
    public void deleteAll(DeleteSQL deleteSQL);

    public void update(UpdateSQL updateSQL);
    
    public Response<Long> count(SelectSQL selectSQL);
    
    public Response<SysRoleInfo> findOne(SelectSQL selectSQL);
    
    public Response<List<SysRoleInfo>> findList(SelectSQL selectSQL);
}
