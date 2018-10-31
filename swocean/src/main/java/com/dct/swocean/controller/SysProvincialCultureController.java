package com.dct.swocean.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysFamilyCultureService;
import com.dct.swocean.util.Response;

/**
 * 省级家族文化除家族字派
 *
 */
@RestController
@RequestMapping(value = "/provincial", method = RequestMethod.POST)
public class SysProvincialCultureController {

	@Autowired
	private SysFamilyCultureService sysFamilyCultureService;

	// 省级家族文化分类查询
	@RequestMapping(value = "/typeQuerying", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> typeQuerying(@RequestParam("parentId") Integer parentId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysRightinfoInfo> addClassify = sysFamilyCultureService.typeQuerying(parentId);
		return addClassify;
	}

	// 资讯前台 查询家族文化分类分页信息 除了家族字派
	@RequestMapping(value = "/consult", method = RequestMethod.POST)
	public Response<CulturePage> consult(@RequestParam("userId") String userId,
			@RequestParam(value = "style") Integer style, // 文章分类类型
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "1") Integer status, // 状态1 表示发表0表示草稿 2表示删除
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culture = sysFamilyCultureService.culture(userId, style, pageNow, pageSize, areaCode,
				familyName, status, type);
		return culture;
	}

	// 前台增加收藏数 除了家族字派
	@RequestMapping(value = "/collection", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> collection(@RequestParam("writingsId") String writingsId,
			@RequestParam("userId") String userId, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 收藏
		Response<SysWritingInfo> response = sysFamilyCultureService.insertCollection(writingsId, userId);
		return response;
	}

	// 前台增加点赞 除了家族字派
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> like(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysWritingInfo> insertLike = sysFamilyCultureService.insertLike(writingsId);
		return insertLike;
	}

	// 前台查看详情增加查看数 除了家族字派
	@RequestMapping(value = "/particulars", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<FamilyIndustry> particulars(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<FamilyIndustry> selectParticulars = sysFamilyCultureService.selectParticulars(writingsId);
		return selectParticulars;
	}

	// 省级下属县级官网
	@RequestMapping(value = "/provincialUnderling", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysConstantInfo> provincialUnderling(@RequestParam("areaCode") String areaCode, // 省级ID
			@RequestParam("familyName") String familyName, // 姓氏
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysConstantInfo> provincialUnderling = sysFamilyCultureService.provincialUnderling(areaCode,
				familyName);
		return provincialUnderling;
	}

	// 省级家族文化后台文章分类添加
	@RequestMapping(value = "/addClassify", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> addClassify(@RequestParam("column") String column,
			@RequestParam("rightName") String rightName, HttpServletResponse res) {// 文章分类名称
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysRightinfoInfo> addClassify = sysFamilyCultureService.addClassify(column, rightName);
		return addClassify;
	}

	// 省级家族文化后台文章分类删除 style分类的ID
	@RequestMapping(value = "/deleteClassify", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> deleteClassify(@RequestParam("rightId") int rightId, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysRightinfoInfo> response = sysFamilyCultureService.deleteClassify(rightId);
		return response;
	}

	// 省级家族文化后台添加 进入添加页面显示草稿
	@RequestMapping(value = "/addPublish", method = RequestMethod.POST)
	public Response<CulturePage> addPublish(@RequestParam("userId") String userId,
			@RequestParam(value = "column", defaultValue = "2") String column,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type, // 05代表发表的文章
			@RequestParam(value = "status", defaultValue = "0") Integer status, // 状态0 表示草稿1表示发表2表示已删除
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culturePublish = sysFamilyCultureService.culturePublish(userId, column, areaCode,
				familyName, pageNow, pageSize, type, status);
		return culturePublish;
	}

	// 省级后台草稿详情
	@RequestMapping(value = "/offspring", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> offspring(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysWritingInfo> detailsPublish = sysFamilyCultureService.detailsPublish(writingsId);
		return detailsPublish;
	}

	// 省级后台草稿修改页面
	@RequestMapping(value = "/offspringPublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> offspringPublish(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysWritingInfo> detailsPublish = sysFamilyCultureService.detailsPublish(writingsId);
		return detailsPublish;
	}

	// 省级后台草稿修改页面发表或者保存为草稿
	@RequestMapping(value = "/updateDraft", method = RequestMethod.POST)
	public Response<SysWritingInfo> updateDraft(@RequestParam("writingsId") String writingsId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, @RequestParam("pic") String pic,
			@RequestParam("synopsis") String synopsis, // 简介
			@RequestParam("status") Integer status, // 状态1是发表 状态0是草稿 状态2不能显示表示已删除
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> amendPublish = sysFamilyCultureService.amendPublish(writingsId, title, text, style,
				pic, status, synopsis);
		return amendPublish;
	}

	// 省级家族文化后台信息查询**********************************************
	@RequestMapping(value = "/backstageCommonality", method = RequestMethod.POST)
	public Response<CulturePage> backstageCommonality(@RequestParam("userId") String userId,
			@RequestParam(value = "style") Integer style, @RequestParam(value = "areaCode") String areaCode, // areaCode
																												// 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> backstageCommonality = sysFamilyCultureService.backstageCommonality(userId, style,
				pageNow, pageSize, areaCode, familyName);
		return backstageCommonality;
	}

	// 省级家族文化后台查看详情
	@RequestMapping(value = "/backstage", method = RequestMethod.POST)
	public Response<FamilyIndustry> backstage(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<FamilyIndustry> backstage = sysFamilyCultureService.backstage(writingsId);
		return backstage;
	}

	// 省级家族文化后台进入修改页面
	@RequestMapping(value = "/amend", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> amend(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysWritingInfo> amend = sysFamilyCultureService.amend(writingsId);
		return amend;
	}

	// 省级家族文化后台进入修改页面后发表或者草稿
	@RequestMapping(value = "/amendPublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> amendPublish(@RequestParam("writingsId") String writingsId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, @RequestParam("pic") String pic,
			@RequestParam("synopsis") String synopsis, // 简介
			@RequestParam("status") Integer status, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 修改数据
		Response<SysWritingInfo> amendPublish = sysFamilyCultureService.amendPublish(writingsId, title, text, style,
				pic, status, synopsis);
		return amendPublish;
	}

	// 省级家族文化后台文章数据删除
	@RequestMapping(value = "/deleteData", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> deleteData(@RequestParam("writingsId") String writingsId,
			@RequestParam("status") Integer status) {
		Response<SysWritingInfo> deleteData = sysFamilyCultureService.deleteData(writingsId,status);
		return deleteData;
	}
	
	/*//省级家族文化后台文章推荐
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> recommend(@RequestParam("writingsId") String writingsId,
			@RequestParam("status") Integer status) {
		Response<SysWritingInfo> deleteData = sysFamilyCultureService.recommend(writingsId,status);
		return deleteData;
	}*/

}
