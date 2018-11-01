package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.dao.FamilyIndustryMapper2;
import com.dct.swocean.dao.SysAreaInfoMapper2;
import com.dct.swocean.dao.SysWritingInfoMapper2;
import com.dct.swocean.dao.SysZipaiInfoMapper2;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysCultureService;
import com.dct.swocean.util.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysCultureServiceImpl implements SysCultureService {

	@Autowired
	private SysAreaInfoMapper2 sysAreaInfoMapper;
	@Autowired
	private FamilyIndustryMapper2 familyIndustryMapper;
	@Autowired
	private SysZipaiInfoMapper2 sysZipaiInfoMapper;
	@Autowired
	private SysWritingInfoMapper2 sysWritingInfoMapper;

	// 家族文化分类展示
	@Override
	public List<SysWritingInfo> culture(Integer pageSize, Integer pageNow, String style, String areaCode) {

		// 查询家族文化详细信息
		String sql = "select * from sys_writing w,sys_area where area_code=" + "'" + areaCode + "'" + "and style=" + "'"
				+ style + "'" + " order by publish_time desc limit " + pageNow + "," + pageSize;
		List<SysWritingInfo> list = sysWritingInfoMapper.findList(sql);

		return list;
		/*
		 * sql = "SELECT w.* FROM sys_writing w WHERE w.region='" +
		 * sysAreaInfo.getAreaCode() + "' AND w.family='" + sysAreaInfo.getSurname() +
		 * "' AND w.style='" + style + "' ORDER BY  publish_time DESC";
		 */ /*
			 * List<FamilyIndustry> cultureList = familyIndustryMapper.findList(sql); for
			 * (FamilyIndustry familyIndustry : cultureList) {
			 * familyIndustry.setConstantName(sysAreaInfo.getAreaName()); }
			 */
		/*
		 * List<SysWritingInfo> list = sysWritingInfoMapper.findList(sql);
		 * List<RecordNotice> recordNotice = new ArrayList<>(); for (SysWritingInfo
		 * sysWritingInfo : list) { RecordNotice record = new RecordNotice();
		 * record.setAreaName(sysAreaInfo.getAreaName());
		 * record.setSummary(sysWritingInfo.getSummary());
		 * record.setPic(sysWritingInfo.getPic());
		 * record.setText(sysWritingInfo.getText()); recordNotice.add(record); }
		 */
		// 转换成pageInfo对象
		/*
		 * PageInfo<FamilyIndustry> pageInfo = new PageInfo<>(cultureList); CulturePage
		 * culturePage = new CulturePage(); culturePage.setTotal(pageInfo.getTotal());//
		 * 总的信息条数 culturePage.setRows(pageInfo.getList());// 一页信息 return culturePage;
		 */
	}

	// 删除家族文化本县字派记录
	@Override
	public void deleteCulture(String zipaiId) {
		String sql = "DELETE FROM sys_zipai WHERE zipai_id = '" + zipaiId + "'";
		sysZipaiInfoMapper.delete(sql);
	}

	// 修改家族文化本县字派记录
	@Override
	public void updaleCulture(String zipaiId, String region, String zipaiOrder, String ancestorsName) {
		// 生成时间
		Timestamp format = DateUtil.format(new Date());
		String sql = " UPDATE sys_zipai SET zipai_order='" + zipaiOrder + "',region='" + region + "'"
				+ ",ancestors_name='" + ancestorsName + "',create_time='" + format + "',status='" + 1
				+ "' WHERE zipai_id='" + zipaiId + "'; ";
		sysAreaInfoMapper.update(sql);

	}

	// 家族文化后台文章分类

}
