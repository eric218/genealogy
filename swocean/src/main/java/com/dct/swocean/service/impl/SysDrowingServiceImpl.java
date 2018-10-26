package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.IDUtils;
import com.dct.swocean.dao.SysDrowingInfoMapper;
import com.dct.swocean.entity.SysDrowingInfo;
import com.dct.swocean.service.SysDrowingService;
import com.dct.swocean.util.DateUtil;

@Service
public class SysDrowingServiceImpl implements SysDrowingService {

	@Autowired
	private SysDrowingInfoMapper sysDrowingInfoMapper;

	@Override
	public void insert(SysDrowingInfo sysDrowingInfo) {

		String id = String.valueOf(IDUtils.genId());
		Timestamp format = DateUtil.format(new Date());

		String sql = "insert into sys_drowing values(" + "'" + id + "'" + "," + "'" + sysDrowingInfo.getDrowAmount()
				+ "'" + "," + "'" + format + "'" + "," + "'" + sysDrowingInfo.getDrowName() + "'" + "," + "'"
				+ sysDrowingInfo.getDrowOutNum() + "'" + "," + "'" + sysDrowingInfo.getDrowInNum() + "'" + "," + "'"
				+ sysDrowingInfo.getDrowInName() + "'" + "," + "'" + sysDrowingInfo.getDrowBank() + "'" + ")";
		sysDrowingInfoMapper.insert(sql);
	}

	@Override
	public List<SysDrowingInfo> select(String areaCode, Integer pageNo, Integer pageSize) {
		String sql = "select * from sys_drowing,sys_area,sys_account where area_code=" + "'" + areaCode + "'"
				+ " and name=area_name order by drow_time desc limit " + pageNo + "," + pageSize;
		return sysDrowingInfoMapper.findList(sql);
	}

}
