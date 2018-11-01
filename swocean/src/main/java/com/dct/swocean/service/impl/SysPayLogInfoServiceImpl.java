package com.dct.swocean.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.IDUtils;
import com.dct.swocean.dao.SysAccountInfoMapper2;
import com.dct.swocean.dao.SysAreaInfoMapper2;
import com.dct.swocean.dao.SysConstantInfoMapper2;
import com.dct.swocean.dao.SysPayLogInfoMapper2;
import com.dct.swocean.dao.SysUserInfoMapper2;
import com.dct.swocean.dao.SysUserLoginInfoMappeer2;
import com.dct.swocean.entity.SysAccountInfo;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysPayLogInfo;
import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.service.SysPayLogInfoService;
import com.dct.swocean.util.DateUtil;

@Service
public class SysPayLogInfoServiceImpl implements SysPayLogInfoService {

	@Autowired
	private SysPayLogInfoMapper2 sysPayLogInfoMapper;

	@Autowired
	private SysUserLoginInfoMappeer2 sysUserLoginInfoMapper;

	@Autowired
	private SysAreaInfoMapper2 sysAreaInfoMapper;

	@Autowired
	private SysAccountInfoMapper2 SysAccountInfoMapper;

	@Autowired
	private SysConstantInfoMapper2 sysConstantInfoMapper;

	@Override
	public void insert(BigDecimal payAccount, String payContent, String creator, String status) {

		String id = String.valueOf(IDUtils.genId());
		Timestamp format = DateUtil.format(new Date());

		// 用戶的信息
		String sql = "select * from sys_user_login where user_id=" + "'" + creator + "'";
		SysUserLoginInfo sysUserLoginInfo = sysUserLoginInfoMapper.findOne(sql);

		// 用戶的地區信息
		sql = "select * from sys_area where area_leader=" + "'" + creator + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);

		// 账户信息
		sql = "select * from sys_account where name=" + "'" + sysAreaInfo.getAreaName() + "'";
		SysAccountInfo sysAccountInfo = SysAccountInfoMapper.findOne(sql);

		// 个人信息
		sql = "select * from sys_constant where constant_code=" + "'" + sysAreaInfo.getSurname() + "'";
		SysConstantInfo sysConstantInfo = sysConstantInfoMapper.findOne(sql);

		// 新增支出信息
		sql = "insert into sys_pay_log(pay_id,pay_count,pay_amount,region,constant_code,pay_content,"
				+ "pay_time,creator,create_time,status) values(" + id + ',' + sysAccountInfo.getAccount() + ','
				+ payAccount + ',' + sysAreaInfo.getAreaType() + ',' + sysAreaInfo.getSurname() + ',' + "'" + payContent
				+ "'" + ',' + "'" + format + "'" + ',' + "'" + creator + "'" + ',' + "'" + format + "'" + "," + "'"
				+ status + "'" + ")";
		sysPayLogInfoMapper.insert(sql);

	}

	// 查询支出信息
	@Override
	public List<SysPayLogInfo> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize) {
		String sql = "select * from sys_pay_log p,sys_area a,sys_account t where a.area_code=" + "'" + areaCode + "'"
				+ "order by pay_time desc limit " + pageNo + "," + pageSize;
		return sysPayLogInfoMapper.findList(sql);
	}

	@Override
	public SysPayLogInfo selectByPayId(String payId) {
		String sql = "select * from sys_pay_log where pay_id = " + "'" + payId + "'";
		return sysPayLogInfoMapper.findOne(sql);
	}

	@Override
	public void deleteByPayId(String payId) {
		String sql = "update sys_pay_log set status = " + 0 + " where pay_id = " + "'" + payId + "'";
		sysPayLogInfoMapper.update(sql);
	}

	@Override
	public void update(String payContent, BigDecimal payAmount, String creator, String payId) {
		String sql = "update sys_pay_log set pay_content =" + "'" + payContent + "'" + "," + "pay_amount = " + "'"
				+ payAmount + "'" + "," + "creator" + "'" + creator + "'" + "where pay_id = " + "'" + payId + "'";

		sysPayLogInfoMapper.update(sql);
	}

}
