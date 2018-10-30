package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FastDFSClient;
import com.dct.swocean.common.IDUtils;
import com.dct.swocean.dao.SysUploadInfoMapper;
import com.dct.swocean.dao.SysWritingInfoMapper;
import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysPLRecordServices;
import com.dct.swocean.util.DateUtil;
/**
 * 省级纪录家族
 * @author xiaohei
 *
 */
@Service
public class SysPLRecordServicesImpl implements SysPLRecordServices{

	@Autowired
	private SysWritingInfoMapper sysWritingInfoMapper;
	
	@Autowired
	private SysUploadInfoMapper sysUploadInfoMapper;
	
	//文章发表
	@Override
	public void inser(SysWritingInfo sysPLRecord) {
		String writings_id = IDUtils.genId() + "";
		Timestamp format = DateUtil.format(new Date());
		String sql ="INSERT INTO `genealogy`.`sys_writing`(`writings_id`, `region`, `title`, `summary`, `text`, `style`, `type`, `publish_time`, `family`) VALUES ('"+writings_id+"', '"+sysPLRecord.getRegion()+"', '"+sysPLRecord.getTitle()+"', '"+sysPLRecord.getSummary()+"', '"+sysPLRecord.getText()+"', "+sysPLRecord.getStyle()+", '"+sysPLRecord.getType()+"', '"+format+"', '"+sysPLRecord.getFamily()+"')";
		sysWritingInfoMapper.insert(sql);
	}
	//视频上传
	@Override
	public void insert(SysUploadInfo sysUploadInfo) {
		String id = IDUtils.genId() + "";
		Timestamp format = DateUtil.format(new Date());
		try {
			FastDFSClient fastDFSClient = new FastDFSClient("C:/Users/xiaohei/Desktop/swocean/src/main/resources/fastDFS.properties");
			String filepath = fastDFSClient.uploadFile(sysUploadInfo.getFilePath());
			String sql = "INSERT INTO `sys_uploadinfo` (`file_id`, `file_name`, `file_type`, `file_path`, `region`, `surname`, `upload_user`, `upload_time`, `status`) VALUES ("
					+ "'"+id+"', '"+sysUploadInfo.getFileName()+"', '"+sysUploadInfo.getFileType()+"', '"+filepath+"', '"+sysUploadInfo.getRegion()+"', '"+sysUploadInfo.getSurname()+"', '"+sysUploadInfo.getUploadUser()+"', '"+format+"', '1')";
			sysUploadInfoMapper.insert(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//分页
	@Override
	public CulturePage culture(Integer pageSize, Integer pageNow, String style, String publisher) {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
