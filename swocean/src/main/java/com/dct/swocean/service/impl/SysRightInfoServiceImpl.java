package com.dct.swocean.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.dao.SysRightinfoInfoMapper2;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.service.SysRightInfoService;

@Service
public class SysRightInfoServiceImpl implements SysRightInfoService {

	@Autowired
	private SysRightinfoInfoMapper2 sysRightinfoInfoMapper;

	@Override
	public SysRightinfoInfo select(Integer id) {
		String sql = "select * from sys_rightinfo where right_id=" + "'" + id + "'";
		return sysRightinfoInfoMapper.findOne(sql);
	}

}
