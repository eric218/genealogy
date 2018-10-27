package com.dct.swocean.service;

import java.math.BigDecimal;

import com.dct.swocean.entity.SysAccountInfo;

public interface SysAccountService {

	// 增加基金总金额 11
	void update(String name, BigDecimal payMoney);

	// 減少基金总金额
	void up(String name, BigDecimal payMoney);

	// 查询基金总金额
	SysAccountInfo selectByAreaCode(String areaCode);
}
