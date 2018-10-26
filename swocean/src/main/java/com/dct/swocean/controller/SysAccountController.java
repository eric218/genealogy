package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.TableStat.Name;
import com.dct.swocean.entity.SysAccountInfo;
import com.dct.swocean.service.SysAccountService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

@Controller
public class SysAccountController {

	@Autowired
	private SysAccountService sysAccountService;

	// 查询基金总金额
	@ResponseBody
	@RequestMapping("select")
	public Response<SysAccountInfo> select(@RequestParam("name") String name) {
		// SysAccountInfo sysAccountInfo = sysAccountService.selectByName(name);
		// return ResponseUtlis.success(sysAccountInfo);
		return null;
	}
}
