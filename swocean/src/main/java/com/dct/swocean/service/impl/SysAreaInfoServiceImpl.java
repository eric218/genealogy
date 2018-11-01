package com.dct.swocean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.dao.SysAreaInfoMapper2;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.service.SysAreaInfoService;

@Service
public class SysAreaInfoServiceImpl implements SysAreaInfoService {

	@Autowired
	private SysAreaInfoMapper2 sysAreaInfoMapper;

	@Override
	public SysAreaInfo select(String id) {
		String sql = "select * from sys_area where area_leader= " + "'" + id + "'";

		return sysAreaInfoMapper.findOne(sql);
	}

}
