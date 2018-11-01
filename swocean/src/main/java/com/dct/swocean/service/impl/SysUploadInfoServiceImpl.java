package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.IDUtils;
import com.dct.swocean.dao.SysUploadInfoMapper2;
import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.service.SysUploadInfoService;
import com.dct.swocean.util.DateUtil;

@Service
public class SysUploadInfoServiceImpl implements SysUploadInfoService {

	@Autowired
	private SysUploadInfoMapper2 sysUploadInfoMapper;

	@Override
	public List<SysUploadInfo> selectByUploadTime(String userId, String fileType, Integer pageNo, Integer pageSize,
			String status) {
		String sql = "select * from sys_uploadinfo where file_type =" + "'" + fileType + "'" + " and upload_user ="
				+ "'" + userId + "'" + "and status =" + "'" + status + "'" + "order by upload_time limit " + pageNo
				+ "," + pageSize;
		List<SysUploadInfo> list = sysUploadInfoMapper.findList(sql);
		return list;
	}

	@Override
	public void insert(SysUploadInfo sysUploadInfo) {
		String id = IDUtils.genId() + "";
		Timestamp format = DateUtil.format(new Date());

		String sql = "insert into sys_uploadinfo (file_id,file_name,file_type,file_path,upload_user,upload_time,status) value "
				+ "(" + id + "," + "'" + sysUploadInfo.getFileName() + "'" + ',' + "'" + sysUploadInfo.getFileType()
				+ "'" + "," + "'" + sysUploadInfo.getFilePath() + "'" + "," + "'" + sysUploadInfo.getUploadUser() + "'"
				+ "," + "'" + format + "'" + "," + sysUploadInfo.getStatus() + ")";
		sysUploadInfoMapper.insert(sql);
	}

	@Override
	public Long count(String userId, String type, Integer status) {
		String sql = "select count(*) from sys_uploadinfo where upload_user =" + "'" + userId + "'" + "and file_type ="
				+ "'" + type + "'" + "and status =" + status;
		return sysUploadInfoMapper.count(sql);
	}

	@Override
	public void updateStatusById(String fileId) {
		Timestamp format = DateUtil.format(new Date());
		String sql = "update sys_uploadinfo set status =" + 0 + "," + " upload_time =" + "'" + format + "'"
				+ " where file_id =" + "'" + fileId + "'";
		sysUploadInfoMapper.update(sql);
	}

}
