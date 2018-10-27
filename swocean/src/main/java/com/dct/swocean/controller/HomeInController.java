package com.dct.swocean.controller;

import com.dct.swocean.service.SysDonationInfoService;
import com.dct.swocean.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping('/homeIn')
public class HomeInController {

    @Autowired
    private SysDonationInfoService sysDonationInfoService;

    //捐款人数
   /* @RequestMapping("donorNum")
    public Response<>*/
}
