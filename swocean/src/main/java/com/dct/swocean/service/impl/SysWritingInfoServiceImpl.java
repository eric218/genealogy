package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyCelebrity;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.common.IDUtils;
import com.dct.swocean.common.RecordNotice;
import com.dct.swocean.dao.FamilyCelebrityMapper;
import com.dct.swocean.dao.FamilyIndustryMapper;
import com.dct.swocean.dao.SysAreaInfoMapper;
import com.dct.swocean.dao.SysConstantInfoMapper;
import com.dct.swocean.dao.SysMessageInfoMapper;
import com.dct.swocean.dao.SysRightinfoInfoMapper;
import com.dct.swocean.dao.SysUserLoginInfoMappeer;
import com.dct.swocean.dao.SysUserRegInofMapper;
import com.dct.swocean.dao.SysWritingInfoMapper;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.entity.SysUserRegInof;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysWritingInfoServiceImpl implements SysWritingInfoService {

	@Autowired
	private SysAreaInfoMapper sysAreaInfoMapper;
	@Autowired
	private SysUserRegInofMapper sysUserRegInofMapper;
	@Autowired
	private SysRightinfoInfoMapper sysRightinfoInfoMapper;
	@Autowired
	private SysWritingInfoMapper sysWritingInfoMapper;
	@Autowired
	private FamilyIndustryMapper familyIndustryMapper;
	@Autowired
	private FamilyCelebrityMapper FamilyCelebrityMapper;
	@Autowired
	private SysMessageInfoMapper sysMessageInfoMapper;
	@Autowired
	private SysUserLoginInfoMappeer sysUserLoginInfoMappeer;
	@Autowired
	private SysConstantInfoMapper sysConstantInfoMapper;

	// 增加数据库信息
	@Override
	public void insertWriting(String title, String text, Integer style, String userId) {
		// 查询地区编号
		String sql = "SELECT a.* FROM sys_area a WHERE a.area_leader=" + "'" + userId + "'";
		SysAreaInfo SysAreaInfo = sysAreaInfoMapper.findOne(sql);
		// 查询栏目
		sql = "SELECT r.* FROM sys_rightinfo r WHERE r.right_id=" + "'" + style + "'";
		SysRightinfoInfo sysRightinfoInfo = sysRightinfoInfoMapper.findOne(sql);
		// 查询简介
		sql = "SELECT u.* FROM sys_user_reg u WHERE u.user_id=" + "'" + userId + "'";
		SysUserRegInof sysUserRegInof = sysUserRegInofMapper.findOne(sql);
		// 插入Writing表中数据
		String id = String.valueOf(IDUtils.genId());
		Timestamp format = DateUtil.format(new Date());
		sql = "INSERT INTO sys_writing(`writings_id`,`region`,`title`,`summary`,`text`,`column`,`style`,`publisher`,`publish_time`)"
				+ "VALUE('" + id + "','" + SysAreaInfo.getRegion() + "','" + title + "','" + sysUserRegInof.getSummary()
				+ "','" + text + "','" + sysRightinfoInfo.getParentId() + "','" + style + "','" + userId + "','"
				+ format + "')";
		sysWritingInfoMapper.insert(sql);
	}

	// 家族公告
	// 查询动态公告数据
	@Override
	public List<RecordNotice> selectWriting(String style, String areaCode, String familyName) {
		// 查询地区名称
		String sql = "SELECT a.* FROM sys_area a WHERE area_code='" + areaCode + "'";
		SysAreaInfo SysAreaInfo = sysAreaInfoMapper.findOne(sql);
		// 根据姓氏名称查出姓氏ID
		sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
		SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
		// 查询sys_writing
		sql = "SELECT w.* FROM sys_writing w WHERE region='" + areaCode + "' AND" + " family='"
				+ constantInfo.getConstantCode() + "' AND style='" + style + "'";
		List<SysWritingInfo> list = sysWritingInfoMapper.findList(sql);
		List<RecordNotice> recordNotice = new ArrayList<>();
		for (SysWritingInfo sysWritingInfo : list) {
			RecordNotice record = new RecordNotice();
			record.setAreaName(SysAreaInfo.getAreaName());
			record.setSummary(sysWritingInfo.getSummary());
			record.setPic(sysWritingInfo.getPic());
			record.setText(sysWritingInfo.getText());
			record.setWritingsId(sysWritingInfo.getWritingsId());
			recordNotice.add(record);
		}
		return recordNotice;
	}

	// 查询最新数据
	@Override
	public List<RecordNotice> newest(String areaCode, String familyName) {
		// 查询地区名称
		String sql = "SELECT a.* FROM sys_area a WHERE area_code='" + areaCode + "'";
		SysAreaInfo SysAreaInfo = sysAreaInfoMapper.findOne(sql);
		// 根据姓氏名称查出姓氏ID
		sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
		SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
		// 查询最新发表信息
		sql = "SELECT w.* FROM sys_writing w WHERE region='" + areaCode + "' AND" + " family='"
				+ constantInfo.getConstantCode() + "'ORDER BY  publish_time DESC";
		// sql = "SELECT w.* FROM sys_writing w WHERE region='" + areaCode + "' ORDER BY
		// publish_time DESC LIMIT 0,6";
		List<SysWritingInfo> list = sysWritingInfoMapper.findList(sql);
		List<RecordNotice> recordNotice = new ArrayList<>();
		for (SysWritingInfo sysWritingInfo : list) {
			RecordNotice record = new RecordNotice();
			record.setAreaName(SysAreaInfo.getAreaName());
			record.setSummary(sysWritingInfo.getSummary());
			record.setPic(sysWritingInfo.getPic());
			record.setText(sysWritingInfo.getText());
			record.setWritingsId(sysWritingInfo.getWritingsId());
			recordNotice.add(record);
		}
		if (recordNotice.size() > 6) {
			List<RecordNotice> subList = recordNotice.subList(0, 7);
			return subList;
		}
		return recordNotice;
	}

	// 家族文化展示
	@Override
	public CulturePage culture(Integer pageSize, Integer pageNow, String style, String userId) {
		// 查询地区编号,名称,姓氏
		String sql = "SELECT a.* FROM sys_area a WHERE a.area_leader=" + "'" + userId + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);
		// 开始分页
		PageHelper.startPage(pageNow, pageSize);
		// 查询家族文化详细信息
		sql = "SELECT w.* FROM sys_writing w WHERE w.region='" + sysAreaInfo.getAreaCode() + "' AND w.family='"
				+ sysAreaInfo.getSurname() + "' AND w.style='" + style + "' ORDER BY  publish_time DESC";
		List<FamilyIndustry> cultureList = familyIndustryMapper.findList(sql);
		for (FamilyIndustry familyIndustry : cultureList) {
			familyIndustry.setConstantName(sysAreaInfo.getAreaName());
		}
		PageInfo<FamilyIndustry> pageInfo = new PageInfo<>(cultureList);
		CulturePage culturePage = new CulturePage();
		culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
		culturePage.setRows(pageInfo.getList());// 一页信息
		return culturePage;
	}

	// 家族名人
	@Override
	public FamilyCelebrity celebrity(String areaCode, String style, String name) {
		String sql = "SELECT u.`real_name`,w.`summary`,w.`text`,w.`pic` FROM sys_area a,sys_writing w,sys_user_reg u WHERE a.area_code="
				+ "'" + areaCode + "'" + "and w.style=" + "'" + style + "'" + "and u.real_name =" + "'" + name + "'";
		FamilyCelebrity familyCelebrity = FamilyCelebrityMapper.findOne(sql);
		return familyCelebrity;
	}

	// 家族产业 个人产业
	public List<FamilyIndustry> industry(String userId, String style) {
		// 查询地区
		String sql = "SELECT a.* FROM sys_area a WHERE area_leader=" + "'" + userId + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);
		sql = "SELECT w.*,a.area_name FROM sys_area a,sys_writing w WHERE w.publisher='" + userId + "' AND w.region='"
				+ sysAreaInfo.getAreaCode() + "' AND w.style='" + style + "' AND a.surname=w.family limit 0,2";
		List<FamilyIndustry> findList = familyIndustryMapper.findList(sql);
		return findList;
	}

	// 家族产业 公共产业
	public List<FamilyIndustry> commonality(String userId, String style) {
		// 查询地区
		String sql = "SELECT a.* FROM sys_area a WHERE area_leader=" + "'" + userId + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);
		/*
		 * //根据地区查询每个地区发表人的id
		 * sql="SELECT w.publisher FROM sys_writing w WHERE w.style='"+style+"'";
		 * List<SysWritingInfo> findList2 = sysWritingInfoMapper.findList(sql);
		 */
		// 遍历查出公共产业
		sql = "SELECT w.*,a.area_name FROM sys_area a,sys_writing w WHERE w.region='" + sysAreaInfo.getAreaCode()
				+ "' AND w.style='" + style + "' AND a.surname=w.family limit 0,2";
		List<FamilyIndustry> findList = familyIndustryMapper.findList(sql);
		/*
		 * for (SysWritingInfo sysWritingInfo : findList2) {
		 * findList.add(familyIndustryMapper.findOne(sql)); }
		 */
		return findList;
	}

	// 用户消息存储
	@Override
	public void answer(String userName, String message) {
		// 根据用户姓名查出用户ID
		String sql = "SELECT u.* FROM sys_user_login u WHERE u.user_name='" + userName + "'";
		SysUserLoginInfo findOne = sysUserLoginInfoMappeer.findOne(sql);
		// 生成消息ID
		String id = String.valueOf(IDUtils.genId());
		// 生成时间
		Timestamp timestamp = DateUtil.format(new Date());
		// 存储用户发的消息sys_message表
		sql = "INSERT INTO sys_message VALUES ('" + id + "','" + findOne.getUserId() + "','" + userName + "','"
				+ message + "','" + timestamp + "','" + 1 + "')";
		sysMessageInfoMapper.insert(sql);
	}

	// 查询用户的登录信息
	public List<SysUserLoginInfo> userList() {
		String sql = "SELECT u.* FROM sys_user_login u";
		List<SysUserLoginInfo> userList = sysUserLoginInfoMappeer.findList(sql);
		return userList;
	}

	@Override
	public Long selectByType(String userId, String type, String status) {
		String sql = "select count(*) from sys_writing where publisher=" + "'" + userId + "'" + " and type =" + "'"
				+ type + "'" + " and status =" + "'" + status + "'";
		return sysWritingInfoMapper.count(sql);
	}

	@Override
	public List<SysWritingInfo> select(String userId, String type, Integer pageNo, Integer pageSize, String status) {
		String sql = "select * from sys_writing where publisher =" + "'" + userId + "'" + "and type =" + "'" + type
				+ "'" + " and status =" + "'" + status + "'" + " limit " + pageNo + "," + pageSize;
		return sysWritingInfoMapper.findList(sql);
	}

	@Override
	public void add(String userId, String region, String text, String type, String status) {

		String id = String.valueOf(IDUtils.genId());
		Timestamp format = DateUtil.format(new Date());

		String sql = "insert into sys_writing(writings_id,region,text,type,publisher,publish_time,status) values ("
				+ "'" + id + "'" + "," + "'" + region + "'" + "," + "'" + text + "'" + "," + "'" + type + "'" + ","
				+ "'" + userId + "'" + "," + "'" + format + "'" + "," + "'" + status + "'" + ")";
		sysWritingInfoMapper.insert(sql);
	}

	@Override
	public void delete(String writingId) {
		Timestamp format = DateUtil.format(new Date());
		String sql = "update sys_writing set status =" + "'" + 0 + "'" + "," + " publish_time =" + "'" + format + "'"
				+ " where writings_id =" + "'" + writingId + "'";
		sysWritingInfoMapper.update(sql);
	}

	@Override
	public SysWritingInfo selectOne(String userId) {
		String sql = "select * from sys_writing  where publisher =" + "'" + userId + "'"
				+ "order by publish_time desc limit 0 ,1";

		return sysWritingInfoMapper.findOne(sql);
	}

	@Override
	public SysWritingInfo selectByWritingId(String userId, String writingId) {
		String sql = "select * from sys_writing where writings_id = " + "'" + writingId + "'";

		return sysWritingInfoMapper.findOne(sql);
	}

	@Override
	public void update(SysWritingInfo sysWritingInfo) {
		Timestamp format = DateUtil.format(new Date());
		String sql = "update sys_writing set title =" + "'" + sysWritingInfo.getTitle() + "'" + "," + "summary =" + "'"
				+ sysWritingInfo.getSummary() + "'" + "," + "text =" + "'" + sysWritingInfo.getText() + "'" + ","
				+ "publish_time =" + "'" + format + "'" + " where writings_id =" + "'" + sysWritingInfo.getWritingsId()
				+ "'";
		sysWritingInfoMapper.update(sql);

	}

	@Override
	public void insert(SysWritingInfo sysWritingInfo) {
		String id = String.valueOf(IDUtils.genId());
		Timestamp format = DateUtil.format(new Date());

		String sql = "insert into sys_writing values (" + "'" + id + "'" + "," + "'" + sysWritingInfo.getRegion() + "'"
				+ "," + "'" + sysWritingInfo.getTitle() + "'" + "," + "'" + sysWritingInfo.getSummary() + "'" + ","
				+ "'" + sysWritingInfo.getText() + "'" + "," + "'" + sysWritingInfo.getColumn() + "'" + ","
				+ sysWritingInfo.getStyle() + "," + "'" + sysWritingInfo.getType() + "'" + "," + "'"
				+ sysWritingInfo.getPublisher() + "'" + "," + "'" + format + "'" + "," + 0 + "," + 0 + "," + 0 + "," + 0
				+ "," + 0 + "," + 1 + "," + "'" + sysWritingInfo.getPic() + "'" + "," + "'" + sysWritingInfo.getFamily()
				+ "'" + "," + 0 + ")";
		sysWritingInfoMapper.insert(sql);

	}

	@Override
	public List<SysWritingInfo> selectPayLog(String style, String areaCode, Integer pageNo, Integer pageSize) {
		String sql = "select * from sys_writing where region =" + "'" + areaCode + "'" + " and style =" + "'" + style
				+ "'" + " limit" + pageNo + "," + pageSize;
		return sysWritingInfoMapper.findList(sql);
	}

	@Override
	public List<SysWritingInfo> selectByTime(String style, String areaCode, Integer pageNo, Integer pageSize) {
		String sql = "select * from sys_writing where region =" + "'" + areaCode + "'" + " and style =" + "'" + style
				+ "'" + " order by publish_time limit" + pageNo + "," + pageSize;
		return sysWritingInfoMapper.findList(sql);
	}
}
