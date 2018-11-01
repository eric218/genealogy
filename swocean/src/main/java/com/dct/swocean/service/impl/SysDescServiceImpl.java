package com.dct.swocean.service.impl;

import com.dct.swocean.dao.SysDescInfoMapper2;
import com.dct.swocean.entity.SysDescInfo;
import com.dct.swocean.service.SysDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDescServiceImpl implements SysDescService {

    @Autowired
    private SysDescInfoMapper2 sysDescInfoMapper;

    @Override
    public SysDescInfo selectByAreaCode(String code) {
        String sql = "select * from sys_desc where area_code =" + "'" + code + "'";
        return sysDescInfoMapper.findOne(sql);
    }
}
