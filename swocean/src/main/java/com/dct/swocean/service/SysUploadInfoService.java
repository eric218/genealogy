package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.entity.SysUploadInfo;

public interface SysUploadInfoService {

	// 查询
	List<SysUploadInfo> selectByUploadTime(String userId, String fileType, Integer pageNo, Integer pageSize,
			String status);

	// 新增
	void insert(SysUploadInfo sysUploadInfo);

	// 计数
	Long count(String userId, String type, Integer status);

	void updateStatusById(String fileId);
}
