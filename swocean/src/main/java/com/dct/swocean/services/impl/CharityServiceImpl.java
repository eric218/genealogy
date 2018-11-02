package com.dct.swocean.services.impl;

import com.dct.swocean.dao.SysAccountMapper;
import com.dct.swocean.dao.SysPayOutMapper;
import com.dct.swocean.entitys.*;
import com.dct.swocean.services.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

    @Autowired
    private SysAccountMapper sysAccountMapper;

    @Autowired
    private SysPayOutMapper sysPayOutMapper;

    @Override
    public List<SysAccount> selectByNetId(Integer netId) {

        SysAccountExample sysAccountExample = new SysAccountExample();
        SysAccountExample.Criteria criteria=sysAccountExample.createCriteria();
        criteria.andNetIdEqualTo(netId);

        List<SysAccount> sysAccounts=sysAccountMapper.selectByExample(sysAccountExample);
        return sysAccounts;
    }

    @Override
    public List<SysPayOut> selectByNetIdAndType(Integer netId, Integer type) {

        SysPayOutExample sysPayOutExample = new SysPayOutExample();
        SysPayOutExample.Criteria criteria = sysPayOutExample.createCriteria();
        criteria.andNetIdEqualTo(netId);
        sysPayOutExample.setOrderByClause("create_time DESC");
      //  criteria.and

        List<SysPayOut> sysPayOuts = sysPayOutMapper.selectByExample(sysPayOutExample);

        return sysPayOuts;
    }

    @Override
    public List<SysNewsCharity> selectSysNewsCharity(Integer netId) {
        return null;
    }
}
