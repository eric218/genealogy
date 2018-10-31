package com.dct.swocean.service;

import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.entity.SysUserLoginInfo;

public interface HomeNewService {

    // 根据用户名查寻用户信息
    SysUserLoginInfo selectByUserName(SysUserLoginInfo SysUserLoginInfo);

}
