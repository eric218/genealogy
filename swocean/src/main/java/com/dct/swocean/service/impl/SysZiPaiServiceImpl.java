package com.dct.swocean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.dao.SysZipaiInfoMapper;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.service.SysZiPaiService;

@Service
public class SysZiPaiServiceImpl implements SysZiPaiService {

	@Autowired
	private SysZipaiInfoMapper sysZipaiInfoMapper;

	@Override
	public List<SysZipaiInfo> selectByFamilyName(String famliyname) {
		String sql = "select * from sys_zipai,sys_constant where constant_name=" + "'" + famliyname + "'";
		return sysZipaiInfoMapper.findList(sql);
	}

	@Override
	public SysZipaiInfo selectByUserId(String userId) {
		String sql = "select * from sys_zipai where creator = " + "'" + userId + "'";
		return sysZipaiInfoMapper.findOne(sql);
	}

	@Override
	public void updateByUserId(SysZipaiInfo sysZipaiInfo) {
		String sql = "update sys_zipai set zipai_order =" + "'" + sysZipaiInfo.getZipaiOrder() + "'"
				+ " where creator = " + "'" + sysZipaiInfo.getCreator() + "'";
		sysZipaiInfoMapper.update(sql);
	}

}
