package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.entity.SysZipaiInfo;

public interface SysZiPaiService {

	// 查询子派(姓氏)
	List<SysZipaiInfo> selectByFamilyName(String famliyname);

	// 查询子派(ID)
	SysZipaiInfo selectByUserId(String userId);

	// 修改子派(ID)
	void updateByUserId(SysZipaiInfo sysZipaiInfo);
}
