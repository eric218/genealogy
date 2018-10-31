package com.dct.swocean.controller;

import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.service.HomeNewService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("homeNew")
public class HomeNewController {

    @Autowired
    private HomeNewService homeNewService;

    @RequestMapping(value = "login")
    public Response<SysUserLoginInfo> login(SysUserLoginInfo sysUserLoginInfo) {

        SysUserLoginInfo sysUserLoginInfo1 = homeNewService.selectByUserName(sysUserLoginInfo);
        return ResponseUtlis.success(sysUserLoginInfo);
    }
}
