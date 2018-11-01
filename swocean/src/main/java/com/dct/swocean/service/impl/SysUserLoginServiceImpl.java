package com.dct.swocean.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.dao.SysUserLoginInfoMappeer2;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.service.SysUserLoginService;
import com.dct.swocean.util.DateUtil;

@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

	@Autowired
	private SysUserLoginInfoMappeer2 sysUserLoginInfoMappeer;

	@Override
	public SysUserLoginInfo selectByUserId(String username) {

		String sql = "select * from sys_user_login where  mobil_phone =" + "'" + username + "'";

		return sysUserLoginInfoMappeer.findOne(sql);
	}

	@Override
	public void insert(SysUserLoginInfo sysUserLoginInfo) {

		String sql = "insert into sys_user_login(user_id,user_name,mobil_phone,password) values (" + "'"
				+ sysUserLoginInfo.getUserId() + "'" + "," + "'" + sysUserLoginInfo.getUserName() + "'" + "," + "'"
				+ sysUserLoginInfo.getMobilPhone() + "'" + "," + "'" + sysUserLoginInfo.getPassword() + "'" + ")";
		sysUserLoginInfoMappeer.insert(sql);
	}

	@Override
	public void update(String mobilePhone, String password) {

		String sql = "update sys_user_login set password =" + "'" + password + "'" + "where mobil_phone =" + "'"
				+ mobilePhone + "'";
		sysUserLoginInfoMappeer.update(sql);
	}

}
