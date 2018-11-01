package com.dct.swocean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.dao.FamilyIndustryMapper2;
import com.dct.swocean.dao.SysAreaInfoMapper2;
import com.dct.swocean.dao.SysConstantInfoMapper2;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.service.SysIndustryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/*
 * 家族产业
 * */

@Service
public class SysIndustryServiceImpl implements SysIndustryService {

	@Autowired
	private SysAreaInfoMapper2 sysAreaInfoMapper;
	@Autowired
	private FamilyIndustryMapper2 familyIndustryMapper;
	@Autowired
	private SysConstantInfoMapper2 sysConstantInfoMapper;

	/**
	 * 私有财产
	 * 
	 * @param userId   用户Id
	 * @param style    分类
	 * @param pageNow  当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	/*
	 * @Override public CulturePage industry(String userId, String style, Integer
	 * pageNow, Integer pageSize) { // 查询地区 String sql =
	 * "SELECT a.* FROM sys_area a WHERE area_leader=" + "'" + userId + "'";
	 * SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql); // 开始分页
	 * PageHelper.startPage(pageNow, pageSize); sql =
	 * "SELECT w.*,a.area_name FROM sys_area a,sys_writing w WHERE w.publisher='" +
	 * userId + "' AND w.region='" + sysAreaInfo.getAreaCode() + "' AND w.style='" +
	 * style + "' AND a.surname=w.family"; List<FamilyIndustry> findList =
	 * familyIndustryMapper.findList(sql); // 转换成pageInfo对象 PageInfo<FamilyIndustry>
	 * pageInfo = new PageInfo<>(findList); CulturePage culturePage = new
	 * CulturePage(); culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
	 * culturePage.setRows(pageInfo.getList());// 一页信息 return culturePage; }
	 */
	@Override
	public List<FamilyIndustry> industry(String style, String areaCode, String familyName) {
		// 查询出姓氏ID
		String sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
		SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);

		sql = "SELECT w.*,a.area_name,u.real_name FROM sys_writing w,sys_area a,sys_user_reg u WHERE w.region='"
				+ areaCode + "' AND w.style='" + style + "' AND w.family='" + constantInfo.getConstantCode()
				+ "'  AND w.publisher=u.user_id limit 0,2";

		List<FamilyIndustry> familyIndustryList = familyIndustryMapper.findList(sql);
		return familyIndustryList;
	}

	/**
	 * 公有财产
	 * 
	 * @param userId   用户ID
	 * @param style    分类
	 * @param pageNow  当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	@Override
	public CulturePage commonality(String userId, String style, Integer pageNow, Integer pageSize) {
		// 查询地区
		String sql = "SELECT a.* FROM sys_area a WHERE area_leader=" + "'" + userId + "'";
		SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);
		// 开始分页
		PageHelper.startPage(pageNow, pageSize);
		sql = "SELECT w.*,a.area_name FROM sys_area a,sys_writing w WHERE w.region='" + sysAreaInfo.getAreaCode()
				+ "' AND w.style='" + style + "' AND a.surname=w.family";
		List<FamilyIndustry> findList = familyIndustryMapper.findList(sql);
		// 转换成pageInfo对象
		PageInfo<FamilyIndustry> pageInfo = new PageInfo<>(findList);
		CulturePage culturePage = new CulturePage();
		culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
		culturePage.setRows(pageInfo.getList());// 一页信息
		return culturePage;
	}

}
