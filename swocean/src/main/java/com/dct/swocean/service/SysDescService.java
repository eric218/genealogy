package com.dct.swocean.service;

import com.dct.swocean.entity.SysDescInfo;

public interface SysDescService {

    //查询联谊会概况
    SysDescInfo selectByAreaCode(String code);

}
