package com.dct.swocean.controllers;

import com.dct.swocean.entitys.SysAccount;
import com.dct.swocean.entitys.SysPayOut;
import com.dct.swocean.services.CharityService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("charity")
@RestController
public class CharityNewController {

    @Autowired
    private CharityService charityService;

    @RequestMapping("selectSysAccount")
    public Response<SysAccount> selectSysAccount(Integer netId) {

        List<SysAccount> sysAccountList= charityService.selectByNetId(netId);
        return ResponseUtlis.success(sysAccountList);
    }

    @RequestMapping("selectSysPayOut")
    public Response<SysPayOut> selectSysPayOut(Integer netId,Integer type) {

        List<SysPayOut> sysPayOutList = charityService.selectByNetIdAndType(netId, type);
        return ResponseUtlis.success(sysPayOutList);
    }
}
