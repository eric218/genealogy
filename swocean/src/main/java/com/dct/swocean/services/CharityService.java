package com.dct.swocean.services;

import com.dct.swocean.entitys.SysAccount;
import com.dct.swocean.entitys.SysNewsCharity;
import com.dct.swocean.entitys.SysPayOut;

import java.util.List;

public interface CharityService {

    //基金总金额
    List<SysAccount> selectByNetId(Integer netId);

    //基金支出
    List<SysPayOut> selectByNetIdAndType(Integer netId,Integer type);

    //捐款新增

    //捐款金额排序


    //财务支出
    List<SysNewsCharity> selectSysNewsCharity(Integer netId);
}
