package com.dct.swocean.service;

import com.dct.swocean.entity.SysUserRegInof;

public interface SysUserRegInfoService {

	// 新增用户
	void insert(SysUserRegInof sysUserRegInfo);

	// 查询用户
	SysUserRegInof selectByUserId(String userId);

	// 修改用户
	void update(SysUserRegInof sysUserRegInof);
}
