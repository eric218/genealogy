package com.dct.swocean.service;

import java.math.BigDecimal;
import java.util.List;

import com.dct.swocean.entity.SysPayLogInfo;

public interface SysPayLogInfoService {

	// 新增支出流水
	void insert(BigDecimal payAccount, String payContent, String creator, String status);

	// 查询支出流水
	List<SysPayLogInfo> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize);

	// 查询一条流水
	SysPayLogInfo selectByPayId(String payId);

	// 删除支出流水
	void deleteByPayId(String payId);

	// 修改支出流水
	void update(String payContent, BigDecimal payAmount, String creator,String payId);
}
