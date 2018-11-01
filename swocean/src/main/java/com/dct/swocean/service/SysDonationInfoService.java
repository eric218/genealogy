package com.dct.swocean.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.dct.swocean.common.Donor;
import com.dct.swocean.entity.SysDonationInfo;

public interface SysDonationInfoService {

	// 新增捐款流水
	void insert(String id, BigDecimal payAmount, String creator, Timestamp format, String payChannel);

	// 查询新增捐款流水
	List<Donor> selectByPayTime(String areaCode, Integer pageNo, Integer pageSize);

	// 查询捐款信息
	List<SysDonationInfo> selectByName(String donor, Integer pageNo, Integer pageSize);

	List<Donor> selectByDonor(String areaCode, Integer pageNo, Integer pageSize);

}
