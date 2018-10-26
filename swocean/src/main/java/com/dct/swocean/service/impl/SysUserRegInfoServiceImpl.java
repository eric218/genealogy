package com.dct.swocean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.dao.SysUserRegInofMapper;
import com.dct.swocean.entity.SysUserRegInof;
import com.dct.swocean.service.SysUserRegInfoService;

@Service
public class SysUserRegInfoServiceImpl implements SysUserRegInfoService {

	@Autowired
	private SysUserRegInofMapper sysUserRegInofMapper;

	@Override
	public void insert(SysUserRegInof sysUserRegInfo) {
		String sql = "insert into sys_user_reg(reg_id,user_id,surname,region,real_name) " + "values (" + null + ","
				+ "'" + sysUserRegInfo.getUserId() + "'" + "," + "'" + sysUserRegInfo.getSurname() + "'" + "," + "'"
				+ sysUserRegInfo.getRegion() + "'" + "," + "'" + sysUserRegInfo.getRealName() + "'" + ")";
		sysUserRegInofMapper.insert(sql);
	}

	@Override
	public SysUserRegInof selectByUserId(String userId) {
		String sql = "select * from sys_user_reg where user_id =" + "'" + userId + "'";
		return sysUserRegInofMapper.findOne(sql);

	}

	@Override
	public void update(SysUserRegInof sysUserRegInof) {
		String sql = "update  sys_user_reg set pic = " + "'" + sysUserRegInof.getPic() + "'" + ","
				+ "present_address = " + "'" + sysUserRegInof.getPresentAddress() + "'" + "," + "old_address = " + "'"
				+ sysUserRegInof.getOldAddress() + "'" + "," + "alias = " + "'" + sysUserRegInof.getAlias() + "'" + ","
				+ "" + "where user_id =" + "'" + sysUserRegInof.getUserId() + "'";
		sysUserRegInofMapper.update(sql);
	}

}
