package com.dct.swocean.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.service.SysFamilyCultureService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import io.swagger.annotations.ApiOperation;


/**
 *家族文化页面
 */
@RestController
@RequestMapping("/civilization")
@SuppressWarnings("unchecked")
public class SysFamilyCultureController {

	@Autowired
	private SysFamilyCultureService sysFamilyCultureService;

	// 资讯前台 查询家族文化分类信息 除了家族字派
	@RequestMapping(value="/consult",method=RequestMethod.POST)
	public Response<CulturePage> consult(@RequestParam("userId") String userId,
			@RequestParam(value = "style") Integer style,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "1") Integer status,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		 Response<CulturePage> culture = sysFamilyCultureService.culture(userId, style, pageNow, pageSize, areaCode, familyName,status,type);
		return culture;
	}

	// 进入前台家族产业发表页面显示草稿信息
	@RequestMapping(value = "/culturePublish", method = RequestMethod.POST)
	public Response<CulturePage> culturePublish(@RequestParam("userId") String userId,
			@RequestParam(value = "column", defaultValue = "2") String column,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "0") Integer status,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culturePublish = sysFamilyCultureService.culturePublish(userId, column, areaCode, familyName,pageNow,pageSize,type,status);
		return culturePublish;
	}
	
	//前台草稿详情
	@RequestMapping(value = "/detailsPublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> detailsPublish(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo sysWritingInfo = sysFamilyCultureService.detailsPublish(writingsId);
			return ResponseUtlis.success(sysWritingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}

	}
	
	//前台草稿修改页面
	@RequestMapping(value = "/updatePublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> updatePublish(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo sysWritingInfo = sysFamilyCultureService.detailsPublish(writingsId);
			return ResponseUtlis.success(sysWritingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}
	
	//前台草稿修改页面发表或者保存为草稿
	@RequestMapping(value = "/updateAnnounce", method = RequestMethod.POST)
	public Response<SysWritingInfo> announce(@RequestParam("writingsId") String writingsId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, 
			@RequestParam("pic") String pic, 
			@RequestParam("synopsis") String synopsis,//简介
			@RequestParam("status") Integer status, // 状态1是发表 状态0是草稿 状态2不能显示表示已删除
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> amendPublish = sysFamilyCultureService.amendPublish(writingsId, title, text, style, pic, status,synopsis);
		return amendPublish;
	}

	//前台家族文化发表页面草稿删除
	@RequestMapping(value = "/deletePublish", method = RequestMethod.POST)
	public Response<SysWritingInfo> deletePublish (@RequestParam("writingsId")String writingsId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysWritingInfo> details = sysFamilyCultureService.deletePublish(writingsId);
		return details;
	}
	
	// 前台页面发表数据
	@RequestMapping(value = "/publishData", method = RequestMethod.POST)
	@ApiOperation(value = "前台页面发表数据")
	public Response<SysWritingInfo> publishData(@RequestParam("userId") String userId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("synopsis") String synopsis,@RequestParam("style") Integer style, 
			@RequestParam("familyName") String familyName, // 姓氏
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam("pic") String pic, @RequestParam("status") Integer status,
			@RequestParam("type") Integer type,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> publishData = sysFamilyCultureService.publishData(userId, title, text, style,synopsis,familyName,areaCode, pic, status,type);
		return publishData;
	}

	// 前台增加收藏数 除了家族字派
	@RequestMapping(value = "/collection", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> collection(@RequestParam("writingsId") String writingsId,
			@RequestParam("userId") String userId,HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//收藏
	    Response<SysWritingInfo> response = sysFamilyCultureService.insertCollection(writingsId,userId);
		return response;
	}

	// 前台增加点赞 除了家族字派
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	@ApiOperation(value = "前台增加点赞")
	// 文章ID writingsId
	public Response<SysWritingInfo> like(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			sysFamilyCultureService.insertLike(writingsId);
			return ResponseUtlis.error(200, "点赞成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "点赞失败");
		}
	}

	// 前台查看详情增加查看数 除了家族字派
	@RequestMapping(value = "/particulars", method = RequestMethod.POST)
	@ApiOperation(value = "前台查看详情增加查看数")
	// 文章ID writingsId
	public Response<FamilyIndustry> particulars(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			FamilyIndustry particulars = sysFamilyCultureService.selectParticulars(writingsId);
			return ResponseUtlis.success(particulars);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}

	
	// 家族文化后台文章分类查询
	@RequestMapping(value = "/typeQuerying", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> typeQuerying(@RequestParam("parentId") Integer parentId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysRightinfoInfo> addClassify = sysFamilyCultureService.typeQuerying(parentId);
		return addClassify;
	}
	
	
	// 家族文化后台文章分类添加
	@RequestMapping(value = "/addClassify", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> addClassify(@RequestParam("column") String column,
			@RequestParam("rightName") String rightName, HttpServletResponse res) {// 文章分类名称
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			sysFamilyCultureService.addClassify(column, rightName);
			return ResponseUtlis.error(200, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "添加失败");
		}
	}

	// 家族文化后台文章分类删除 style分类的ID
	@RequestMapping(value = "/deleteClassify", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> deleteClassify(@RequestParam("rightId") int rightId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysRightinfoInfo> response = sysFamilyCultureService.deleteClassify(rightId);
		return response;
	}

	// **************************************************************************************************************
    //家族文化后台信息查询
	@RequestMapping(value = "/backstageCommonality", method = RequestMethod.POST)
	public Response<CulturePage> backstageCommonality(@RequestParam("userId") String userId,
			@RequestParam(value = "style") Integer style,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		CulturePage culturePage = null;
		culturePage = sysFamilyCultureService.backstageCommonality(userId, style, pageNow, pageSize, areaCode, familyName);
		return ResponseUtlis.success(culturePage);
	}
	

	// **************************************************************************************************************

	// 家族文化后台查看详情
	@RequestMapping(value = "/backstage", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<FamilyIndustry> backstage(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			FamilyIndustry particulars = sysFamilyCultureService.backstage(writingsId);
			return ResponseUtlis.success(particulars);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}

	// 家族文化后台添加 进入添加页面显示草稿
	@RequestMapping(value = "/addPublish", method = RequestMethod.POST)
	public Response<CulturePage> addPublish(@RequestParam("userId") String userId,
			@RequestParam(value = "column", defaultValue = "2") String column,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "0") Integer status,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		 Response<CulturePage> culturePublish = sysFamilyCultureService.culturePublish(userId, column, areaCode, familyName,pageNow,pageSize,type,status);
		return culturePublish;
	}

	// 后台草稿详情
	@RequestMapping(value = "/offspring", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> offspring(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo sysWritingInfo = sysFamilyCultureService.detailsPublish(writingsId);
			return ResponseUtlis.success(sysWritingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}
	
	// 后台草稿修改页面
	@RequestMapping(value = "/offspringPublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> offspringPublish(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo sysWritingInfo = sysFamilyCultureService.detailsPublish(writingsId);
			return ResponseUtlis.success(sysWritingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}
	
	// 前台草稿修改页面发表或者保存为草稿
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
		Response<SysWritingInfo> amendPublish = sysFamilyCultureService.amendPublish(writingsId, title, text, style, pic,
				status, synopsis);
		return amendPublish;
	}
	
	//前台家族文化发表页面草稿删除
		@RequestMapping(value = "/deleteDraft", method = RequestMethod.POST)
		public Response<SysWritingInfo> deleteDraft (@RequestParam("writingsId")String writingsId, HttpServletResponse res){
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			Response<SysWritingInfo> details = sysFamilyCultureService.deletePublish(writingsId);
			return details;
		}
	

	// 家族文化后台添加提交
	@RequestMapping(value = "/addData", method = RequestMethod.POST)
	@ApiOperation(value = "家族产业后台添加")
	public Response<SysWritingInfo> addData(@RequestParam("userId") String userId, @RequestParam("title") String title,
			@RequestParam("text") String text, @RequestParam("style") Integer style,
			@RequestParam("synopsis") String synopsis,@RequestParam("familyName") String familyName, // 姓氏
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID,
			@RequestParam("pic") String pic, @RequestParam("status") Integer status,
			@RequestParam("type") Integer type,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> publishData = sysFamilyCultureService.publishData(userId, title, text, style, synopsis,familyName,areaCode ,pic, status,type);
		return publishData;
	}

	// 家族文化后台进入修改页面
	@RequestMapping(value = "/amend", method = RequestMethod.POST)
	@ApiOperation(value = "家族产业后台进入修改页面")
	// 文章ID writingsId
	public Response<SysWritingInfo> amend(@RequestParam("writingsId") String writingsId, HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo amend = sysFamilyCultureService.amend(writingsId);
			return ResponseUtlis.success(amend);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "进入失败");
		}
	}
	
	// 家族文化后台进入修改页面后发表或者草稿
	@RequestMapping(value = "/amendPublish", method = RequestMethod.POST)
	@ApiOperation(value = "家族产业后台进入修改页面后发表或者草稿")
	// 文章ID writingsId
	public Response<SysWritingInfo> amendPublish(@RequestParam("writingsId") String writingsId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, @RequestParam("pic") String pic,
			@RequestParam("synopsis") String synopsis,//简介
			@RequestParam("status") Integer status, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 修改数据
		Response<SysWritingInfo> amendPublish=sysFamilyCultureService.amendPublish(writingsId, title, text, style, pic, status,synopsis);
		return amendPublish;
	}
	// 家族文化后台文章数据删除
		@RequestMapping(value = "/deleteData", method = RequestMethod.POST)
		@ApiOperation(value = "家族产业后台文章数据删除")
		// 文章ID writingsId
		public Response<SysWritingInfo> deleteData(@RequestParam("writingsId") String writingsId) {
			Response<SysWritingInfo> deleteData = sysFamilyCultureService.deleteData(writingsId);
			return deleteData;
		}
	
}
