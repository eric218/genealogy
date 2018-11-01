package com.dct.swocean.service.impl;

import com.dct.swocean.dao.SysUserLoginInfoMappeer2;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.service.HomeNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeNewServiceImpl implements HomeNewService {

    @Autowired
    private SysUserLoginInfoMappeer2 sysUserLoginInfoMappeer;

    @Override
    public SysUserLoginInfo selectByUserName(SysUserLoginInfo sysUserLoginInfo) {
        String sql = "select * from sys_user_login where  mobil_phone =" + "'" + sysUserLoginInfo.getMobilPhone() + "'";
        return sysUserLoginInfoMappeer.findOne(sql);
    }
}
