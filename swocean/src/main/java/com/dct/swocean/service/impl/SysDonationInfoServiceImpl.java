package com.dct.swocean.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dct.swocean.dao.DonorMapper;
import com.dct.swocean.dao.SysAccountInfoMapper;
import com.dct.swocean.dao.SysAreaInfoMapper;
import com.dct.swocean.dao.SysConstantInfoMapper;
import com.dct.swocean.dao.SysDonationInfoMapper;
import com.dct.swocean.dao.SysUserLoginInfoMappeer;
import com.dct.swocean.entity.Donor;
import com.dct.swocean.entity.SysAccountInfo;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysDonationInfo;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.service.SysDonationInfoService;
import com.dct.swocean.util.DateUtil;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysDonationInfoServiceImpl implements SysDonationInfoService {

	@Autowired
	private SysDonationInfoMapper sysDonationInfoMapper;

	@Autowired
	private SysAreaInfoMapper sysAreaInfoMapper;

	@Autowired
	private SysUserLoginInfoMappeer sysUserLoginInfoMapper;

	@Autowired
	private SysConstantInfoMapper sysConstantInfoMapper;

	@Autowired
	private SysAccountInfoMapper sysAccountInfoMapper;

	@Autowired
	private DonorMapper donorMapper;

	// 新增捐款信息
	@Override
	public void insert(String id, BigDecimal payAmount, String creator, Timestamp format, String payChannel) {

		Timestamp date = DateUtil.format(new Date());

		// 查詢個人信息
		String sql = "select * from sys_user_login where user_id =" + "'" + creator + "'";
		SysUserLoginInfo sysUserLoginInfo = sysUserLoginInfoMapper.findOne(sql);

		// 查询地区信息
		sql = "select * from sys_area where area_leader =" + "'" + creator + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);

		// 查询账号信息
		sql = "select * from sys_account where name=" + "'" + sysAreaInfo.getAreaName() + "'";
		SysAccountInfo sysAccountInfo = sysAccountInfoMapper.findOne(sql);

		// 个人信息
		sql = "select * from sys_constant where constant_code=" + "'" + sysAreaInfo.getSurname() + "'";
		SysConstantInfo sysConstantInfo = sysConstantInfoMapper.findOne(sql);

		// 新增捐款信息
		sql = "insert into sys_donation(donation_id,account,region,donor,constant_code,pay_amount,"
				+ "pay_time,create_time,creator,pay_channel) values(" + id + ',' + sysAccountInfo.getAccount() + ','
				+ sysAreaInfo.getAreaType() + ',' + "'" + sysUserLoginInfo.getUserName() + "'" + ','
				+ sysAreaInfo.getSurname() + ',' + payAmount + ',' + "'" + format + "'" + ',' + "'" + date + "'" + ','
				+ "'" + sysUserLoginInfo.getUserName() + "'" + "," + "'" + payChannel + "'" + ")";
		sysDonationInfoMapper.insert(sql);
	}

	// 查询捐款信息
	@Override
	public List<SysDonationInfo> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize) {
		String sql = "select * from sys_donation d,sys_area a,sys_account t where a.area_code=" + "'" + areaCode + "'"
				+ " order by pay_time desc limit " + pageNo + "," + pageSize;
		return sysDonationInfoMapper.findList(sql);
	}

	// 查询捐款個人信息
	@Override
	public List<SysDonationInfo> selectByName(String donor, Integer pageNo, Integer pageSize) {
		String sql = "select * from sys_donation where donor =" + "'" + donor + "'"
				+ " order by create_time desc limit " + pageNo + "," + pageSize;
		return sysDonationInfoMapper.findList(sql);
	}

	// 查询个人捐款信息
	@Override
	public List<Donor> selectByDonor(String areaCode, Integer pageNo, Integer pageSize) {
		String sql = "select donor,sum(pay_amount) pay_amount,pic,name from sys_donation d,sys_area a,sys_account t,sys_user_reg where t.name=a.area_name AND d.account=t.account and donor=real_name and area_code ="
				+ "'" + areaCode + "'" + "group by donor limit " + pageNo + "," + pageSize;
		return donorMapper.findList(sql);
	}

}
