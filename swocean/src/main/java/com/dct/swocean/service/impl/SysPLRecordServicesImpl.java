package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FastDFSClient;
import com.dct.swocean.common.IDUtils;
import com.dct.swocean.common.RecordNotice;
import com.dct.swocean.dao.SysAreaInfoMapper;
import com.dct.swocean.dao.SysUploadInfoMapper;
import com.dct.swocean.dao.SysWritingInfoMapper;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysPLRecordServices;
import com.dct.swocean.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	
	@Autowired
	private SysAreaInfoMapper sysAreaInfoMapper;
	
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
			FastDFSClient fastDFSClient = new FastDFSClient("C:/Users/xiaohei/Desktop/Git/genealogy/swocean/src/main/resources/fastDFS.properties");
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
		// 开始分页
		PageHelper.startPage(pageNow, pageSize);
		// 查询地区编号和名称
		String sql = "SELECT u.* FROM sys_area a WHERE a.area_leader=" + "'" + publisher + "'";
		SysAreaInfo SysAreaInfo = sysAreaInfoMapper.findOne(sql);
		
		// 查询简介
		sql = "SELECT w.* FROM sys_writing w WHERE w.style='" + style + "' AND w.region='" + SysAreaInfo.getAreaCode()
				+ "' ORDER BY  publish_time DESC";
		List<SysWritingInfo> list = sysWritingInfoMapper.findList(sql);
		List<RecordNotice> recordNotice = new ArrayList<>();
		for (SysWritingInfo sysWritingInfo : list) {
			RecordNotice record = new RecordNotice();
			record.setAreaName(SysAreaInfo.getAreaName());
			record.setSummary(sysWritingInfo.getSummary());
			recordNotice.add(record);
		}
		// 转换成pageInfo对象
		PageInfo<RecordNotice> pageInfo = new PageInfo<>(recordNotice);
		CulturePage culturePage = new CulturePage();
		culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
		culturePage.setRows(pageInfo.getList());// 一页信息
		return culturePage;

	}
		
}
