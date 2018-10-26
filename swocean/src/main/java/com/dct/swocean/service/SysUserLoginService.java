package com.dct.swocean.service;

import com.dct.swocean.entity.SysUserLoginInfo;

public interface SysUserLoginService {

	// 根据用户名查寻用户信息
	SysUserLoginInfo selectByUserId(String username);

	// 新增用户
	void insert(SysUserLoginInfo sysUserLoginInfo);

	// 修改密码
	void update(String mobilePhone, String password);
}
