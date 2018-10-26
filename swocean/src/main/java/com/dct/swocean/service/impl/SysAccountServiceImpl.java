package com.dct.swocean.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.dao.SysAccountInfoMapper;
import com.dct.swocean.dao.SysAreaInfoMapper;
import com.dct.swocean.entity.SysAccountInfo;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.service.SysAccountService;

@Service
public class SysAccountServiceImpl implements SysAccountService {

	@Autowired
	private SysAccountInfoMapper sysAccountInfoMapper;

	@Autowired
	private SysAreaInfoMapper sysAreaInfoMapper;

	// 增加基金总金额
	@Override
	public void update(String creator, BigDecimal payMoney) {

		// 查询地区信息
		String sql = "select * from sys_area where area_leader =" + "'" + creator + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);

		// 查询账号信息
		sql = "select * from sys_account where name=" + "'" + sysAreaInfo.getAreaName() + "'";
		SysAccountInfo sysAccountInfo = sysAccountInfoMapper.findOne(sql);

		// 修改基金总金额
		BigDecimal remain = sysAccountInfo.getRemain().add(payMoney);
		sql = "update sys_account set remain = " + "'" + remain + "'" + "where name =" + "'" + sysAccountInfo.getName()
				+ "'";
		sysAccountInfoMapper.update(sql);
	}

	// 减少基金总金额
	@Override
	public void up(String creator, BigDecimal payMoney) {

		// 查询地区信息
		String sql = "select * from sys_area where area_leader =" + "'" + creator + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);

		// 查询账号信息
		sql = "select * from sys_account where name=" + "'" + sysAreaInfo.getAreaName() + "'";
		SysAccountInfo sysAccountInfo = sysAccountInfoMapper.findOne(sql);

		// 修改基金总金额
		BigDecimal remain = sysAccountInfo.getRemain().subtract(payMoney);
		sql = "update sys_account set remain = " + "'" + remain + "'" + "where name =" + "'" + sysAccountInfo.getName()
				+ "'";
		sysAccountInfoMapper.update(sql);
	}

	// 查询基金总金额
	@Override
	public SysAccountInfo selectByAreaCode(String areaCode) {
		String sql = "select * from sys_account ,sys_area where area_Code =" + "'" + areaCode + "'";
		return sysAccountInfoMapper.findOne(sql);
	}

}
