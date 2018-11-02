package com.dct.swocean.services.impl;

import com.dct.swocean.dao.SysAccountMapper;
import com.dct.swocean.entitys.SysAccount;
import com.dct.swocean.entitys.SysAccountExample;
import com.dct.swocean.services.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

    @Autowired
    private SysAccountMapper sysAccountMapper;

    @Override
    public List<SysAccount> selectByNetId(Integer netId) {

        SysAccountExample sysAccountExample = new SysAccountExample();
        SysAccountExample.Criteria criteria=sysAccountExample.createCriteria();
        criteria.andNetIdEqualTo(netId);

        List<SysAccount> sysAccounts=sysAccountMapper.selectByExample(sysAccountExample);
        return sysAccounts;
    }
}
