package com.dct.swocean.services;

import com.dct.swocean.entitys.SysAccount;

import java.util.List;

public interface CharityService {

    //基金总金额
    List<SysAccount> selectByNetId(Integer netId);

}
