package com.dct.swocean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dct.swocean.dao.SysRoleInfoMapper2;
import com.dct.swocean.entity.SysRoleInfo;
import com.dct.swocean.service.SysRoleInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.dbhelper.DeleteSQL;
import com.dct.swocean.util.dbhelper.InsertSQL;
import com.dct.swocean.util.dbhelper.SelectSQL;
import com.dct.swocean.util.dbhelper.UpdateSQL;

@Service
@CacheConfig(cacheNames = "roleCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysRoleInfoServiceImpl implements SysRoleInfoService
{
    @Autowired
    private SysRoleInfoMapper2 mapper;

    @Override
    public void insert(InsertSQL insertSQL)
    {
    }

    @Override
    public void delete(DeleteSQL deleteSQL)
    {
    }

    @Override
    public void deleteAll(DeleteSQL deleteSQL)
    {

    }

    @Override
    public void update(UpdateSQL updateSQL)
    {
    }

    @Override
    public Response<Long> count(SelectSQL selectSQL)
    {
        return null;
    }

    @Override
    public Response<SysRoleInfo> findOne(SelectSQL selectSQL)
    {
        return null;
    }

    @Override
    public Response<List<SysRoleInfo>> findList(SelectSQL selectSQL)
    {
        return null;
    }

}
