package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.IDUtils;
import com.dct.swocean.common.RecordNotice;
import com.dct.swocean.dao.SysAreaInfoMapper2;
import com.dct.swocean.dao.SysWritingInfoMapper2;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysCelebrityInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysPlCelebrityServices;
import com.dct.swocean.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 省级家族名人
 * @author xiaohei
 *
 */
@Service
public class SysPLCelebrityServiceImpl implements SysPlCelebrityServices{
	@Autowired
	private SysWritingInfoMapper2 sysWritingInfoMapper;

	@Autowired
	private SysAreaInfoMapper2 sysAreaInfoMapper;

	@Override
	public void inser(SysWritingInfo sysWritingInfo) {
		String writings_id = IDUtils.genId() + "";
		Timestamp format = DateUtil.format(new Date());
		
		String sql ="INSERT INTO `genealogy`.`sys_writing`("
				+ "`writings_id`,"
				+ " `region`,"
				+ " `title`,"
				+ " `summary`,"
				+ " `text`,"
				+ " `column`,"
				+ " `style`,"
				+ " `type`,"
				+ " `publisher`,"
				+ " `publish_time`,"
				+ " `focus`,"
				+ " `like`,"
				+ " `share`, "
				+ " `relay`,"
				+ " `reward`,"
				+ " `status`,"
				+ " `pic`,"
				+ " `family`,"
				+ " `collection`"+ ") VALUES ("
				+ "'"+writings_id+"', "
				+ "'"+sysWritingInfo.getRegion()+"', "
				+ "'"+sysWritingInfo.getTitle()+"', "
				+ "'"+sysWritingInfo.getSummary()+"', "
				+ "'"+sysWritingInfo.getText()+"',"
				+ " '"+sysWritingInfo.getColumn()+"',"
				+ " "+sysWritingInfo.getStyle()+","
				+ " '"+sysWritingInfo.getType()+"',"
				+ " '"+sysWritingInfo.getPublisher()+"',"
				+ " '"+format+"',"
				+ " "+sysWritingInfo.getFocus()+","
				+ " "+sysWritingInfo.getLike()+","
				+ " "+sysWritingInfo.getShare()+","
				+ " "+sysWritingInfo.getRelay()+","
				+ " "+sysWritingInfo.getReward()+","
				+ " "+sysWritingInfo.getStatus()+","
				+ " '"+sysWritingInfo.getPic()+"',"
				+ " '"+sysWritingInfo.getFamily()+"',"
				+ " "+sysWritingInfo.getCollection()+")";
		sysWritingInfoMapper.insert(sql);
	}

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
	//编辑更新
	@Override
	public void update(SysCelebrityInfo sysCelebrityInfo) {
		Timestamp format = DateUtil.format(new Date());
		String sql = "UPDATE `sys_celebrity` SET `pic`='"+sysCelebrityInfo.getPic()+"', `celebrity_time`='"+format+"', `user_id`='"+sysCelebrityInfo.getUser_id()+"', `celebrity_name`='"+sysCelebrityInfo.getCelebrity_name()+"', `summary`='"+sysCelebrityInfo.getSummary()+"' WHERE (`celebrity_id`='"+sysCelebrityInfo.getCelebrity_id()+"')";
		sysWritingInfoMapper.update(sql);
	}
	//编辑前查询
	@Override
	public void select(SysCelebrityInfo sysCelebrityInfo) {
		
		String sql ="SELECT * FROM `sys_celebrity` WHERE celebrity_id = '"+sysCelebrityInfo.getCelebrity_id()+"'";
		sysWritingInfoMapper.findOne(sql);
	}
}
