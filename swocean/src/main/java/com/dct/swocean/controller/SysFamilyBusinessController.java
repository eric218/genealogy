package com.dct.swocean.controller;


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
import com.dct.swocean.service.SysFamilyBusinessService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * 家族产业栏目
 *
 */

@RestController
@RequestMapping(value="/business",method=RequestMethod.POST)
@SuppressWarnings("unchecked")
public class SysFamilyBusinessController {

	@Autowired
	private SysFamilyBusinessService SysFamilyBusinessService;

	// 前台查询公共产业 个人产业
	 @RequestMapping(value = "/commonality", method = RequestMethod.POST)
	public Response<CulturePage> commonality(@RequestParam("userId") String userId,
			@RequestParam(value = "style", defaultValue = "15") Integer style, //文章分类
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "1") Integer status,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> industry = SysFamilyBusinessService.industry(userId, style, pageNow, pageSize, areaCode, familyName,status,type);
		return industry;
	}

	// 进入前台家族产业发表页面显示草稿信息 发表
	@RequestMapping(value = "/culturePublishMore", method = RequestMethod.POST)
	public Response<CulturePage> culturePublishMore(
			@RequestParam(value = "column", defaultValue = "11") String column,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "0") Integer status,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culturePublish = SysFamilyBusinessService.culturePublish( column, areaCode, familyName, pageNow,
				pageSize,type,status);
		return culturePublish;
	}

	// 进入前台家族产业发表页面草稿详情
	@RequestMapping(value = "/detailsPublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> detailsPublish(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo sysWritingInfo = SysFamilyBusinessService.detailsPublish(writingsId);
			return ResponseUtlis.success(sysWritingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}
	
	//进入前台家族产业发表页面草稿进入修改
	@RequestMapping(value = "/updatePublish", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> updatePublish(@RequestParam("writingsId") String writingsId,
			HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			SysWritingInfo sysWritingInfo = SysFamilyBusinessService.detailsPublish(writingsId);
			return ResponseUtlis.success(sysWritingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}
	
	//进入前台家族产业发表页面草稿进入修改页面后发表
	@RequestMapping(value = "/updateAnnounce", method = RequestMethod.POST)
	public Response<SysWritingInfo> announce  (@RequestParam("writingsId") String writingsId,
					@RequestParam("title") String title, @RequestParam("text") String text,
					@RequestParam("synopsis") String synopsis,//简介
					@RequestParam("style") Integer style, @RequestParam("location") String location, //具体产业地址
					@RequestParam("pic") String pic, @RequestParam("status") Integer status,//状态1是发表 状态0是草稿 状态2不能显示表示已删除
					 HttpServletResponse res) {
		        // 跨域解决
				res.setHeader("Access-Control-Allow-Origin", "*");
				// 插入数据
				Response<SysWritingInfo> amendPublish = SysFamilyBusinessService.amendPublish(writingsId,title, text, style, location, pic, status,synopsis);
				return amendPublish;
			}

	//进入前台家族产业发表页面草稿删除
	@RequestMapping(value = "/deletePublish", method = RequestMethod.POST)
	public Response<SysWritingInfo> deletePublish (@RequestParam("writingsId")String writingsId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysWritingInfo> details = SysFamilyBusinessService.deletePublish(writingsId);
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
			@RequestParam("location") String location,
			@RequestParam(value="type",defaultValue="05") String type,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> publishData = SysFamilyBusinessService.publishData(userId, title, text, style,synopsis,familyName,areaCode ,pic, status,location,type);
		return publishData;
	}

	// 前台增加收藏数
	@RequestMapping(value = "/collection", method = RequestMethod.POST)
	@ApiOperation(value = "前台增加收藏数")
	// 文章ID writingsId
	public Response<SysWritingInfo> collection(@RequestParam("writingsId") String writingsId,
			@RequestParam("userId") String userId,HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//收藏
	    Response<SysWritingInfo> response = SysFamilyBusinessService.collect(writingsId,userId);
		return response;
	}

	// 前台增加点赞
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	@ApiOperation(value = "前台增加点赞")
	// 文章ID writingsId
	public Response<SysWritingInfo> like(@RequestParam("writingsId") String writingsId,HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			//点赞
			SysFamilyBusinessService.insertLike(writingsId);
			return ResponseUtlis.error(200, "点赞成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "点赞失败");
		}

	}

	// 前台查看详情增加查看数
	@RequestMapping(value = "/particulars", method = RequestMethod.POST)
	@ApiOperation(value = "前台查看详情增加查看数")
	// 文章ID writingsId
	public Response<FamilyIndustry> particulars(@RequestParam("writingsId") String writingsId,HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			//增加查看			
			FamilyIndustry particulars = SysFamilyBusinessService.selectParticulars(writingsId);
			return ResponseUtlis.success(particulars);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}

	// 家族产业后台文章分类查询
	@RequestMapping(value = "/typeQuerying", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> typeQuerying(@RequestParam("parentId") Integer parentId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysRightinfoInfo> addClassify = SysFamilyBusinessService.typeQuerying(parentId);
		return addClassify;
	}
	
	// 家族产业后台文章分类添加
	@RequestMapping(value = "/addClassify", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> addClassify(@RequestParam("column") String column,
			@RequestParam("rightName") String rightName,HttpServletResponse res) {//文章分类名称
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			//文章分类添加
			SysFamilyBusinessService.addClassify(column, rightName);
			return ResponseUtlis.error(200, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "添加失败");
		}
	}
	
	// 家族产业后台文章分类删除 style分类的ID
		@RequestMapping(value = "/deleteClassify", method = RequestMethod.POST)
		public Response<SysRightinfoInfo> deleteClassify(@RequestParam("rightName") String rightName,
				HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//文章分类删除
		Response<SysRightinfoInfo> response = SysFamilyBusinessService.deleteClassify(rightName);
		return response;
	}

	//************************************* 
	//家族产业后台查询公共个人产业查询
		@RequestMapping(value = "/backstageCommonality", method = RequestMethod.POST)
		public Response<CulturePage> backstageCommonality(@RequestParam("userId") String userId,
				@RequestParam(value = "style", defaultValue = "15") Integer style,
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
				@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
				@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
				@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
				@RequestParam(value = "type", defaultValue = "05") String type,
				HttpServletResponse res) {
			
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			CulturePage culturePage = null;
			culturePage = SysFamilyBusinessService.backstageCommonality(userId, style, pageNow, pageSize, areaCode, familyName,type);
			return ResponseUtlis.success(culturePage);
		}
	
	
	// 家族产业后台查看详情
	@RequestMapping(value = "/backstage", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<FamilyIndustry> backstage(@RequestParam("writingsId") String writingsId,HttpServletResponse res) {
		try {
			// 跨域解决
			res.setHeader("Access-Control-Allow-Origin", "*");
			//查看详情
			FamilyIndustry particulars = SysFamilyBusinessService.backstage(writingsId);
			return ResponseUtlis.success(particulars);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}

	// 家族产业后台文章数据删除
	@RequestMapping(value = "/deleteData", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> deleteData(@RequestParam("writingsId") String writingsId,HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//文章数据删除
		Response<SysWritingInfo> deleteData = SysFamilyBusinessService.deleteData(writingsId);
		return deleteData;
	}
	
	// 家族产业后台发表页面显示草稿信息
	@RequestMapping(value = "/addPublishMore", method = RequestMethod.POST)
	public Response<CulturePage> addPublishMore(
			@RequestParam(value = "column", defaultValue = "11") String column,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "05") String type,
			@RequestParam(value = "status", defaultValue = "0") Integer status,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
	Response<CulturePage> culturePublish = SysFamilyBusinessService.culturePublish(column, areaCode,
				familyName,pageNow,pageSize,type,status);
		return culturePublish;
		}
	// 进入后台家族产业发表页面草稿详情
		@RequestMapping(value = "/offspring", method = RequestMethod.POST)
		// 文章ID writingsId
		public Response<SysWritingInfo> offspring (@RequestParam("writingsId") String writingsId,
				HttpServletResponse res) {
			try {
				// 跨域解决
				res.setHeader("Access-Control-Allow-Origin", "*");
				SysWritingInfo sysWritingInfo = SysFamilyBusinessService.detailsPublish(writingsId);
				return ResponseUtlis.success(sysWritingInfo);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseUtlis.error(500, "查询失败");
			}

		}
		
		//进入后台家族产业发表页面草稿进入修改
		@RequestMapping(value = "/offspringPublish", method = RequestMethod.POST)
		// 文章ID writingsId
		public Response<SysWritingInfo> offspringPublish(@RequestParam("writingsId") String writingsId,
				HttpServletResponse res) {
			try {
				// 跨域解决
				res.setHeader("Access-Control-Allow-Origin", "*");
				//进入修改
				SysWritingInfo sysWritingInfo = SysFamilyBusinessService.detailsPublish(writingsId);
				return ResponseUtlis.success(sysWritingInfo);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseUtlis.error(500, "查询失败");
			}
		}
	
	//家族产业前台后台发表页面上草稿修改提交
	@RequestMapping(value = "/updateDraft", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> updatePublish(@RequestParam("writingsId") String writingsId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, @RequestParam("location") String location, //具体产业地址
			@RequestParam("pic") String pic, @RequestParam("status") Integer status,
			@RequestParam("synopsis") String synopsis,//简介
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> amendPublish = SysFamilyBusinessService.amendPublish(writingsId,title, text, style, location, pic, status,synopsis);
		return amendPublish;
	}
	
	//家族产业前台后台发表页面上草稿删除
	@RequestMapping(value = "/deleteDraft", method = RequestMethod.POST)
	// 文章ID writingsId
	public Response<SysWritingInfo> deleteDraft(@RequestParam("writingsId") String writingsId,HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//删除
		Response<SysWritingInfo> deleteDraft = SysFamilyBusinessService.deleteDraft(writingsId);
		return deleteDraft;
	}

	// 家族产业后台添加数据提交
	@RequestMapping(value = "/addData", method = RequestMethod.POST)
	@ApiOperation(value = "家族产业后台添加")
	public Response<SysWritingInfo> addData(@RequestParam("userId") String userId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("synopsis") String synopsis,@RequestParam("style") Integer style,
			@RequestParam("familyName") String familyName, // 姓氏
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam("pic") String pic, @RequestParam("status") Integer status,
			@RequestParam("location") String location,
			@RequestParam(value = "type", defaultValue = "05") String type,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> publishData = SysFamilyBusinessService.publishData(userId, title, text, style, synopsis, familyName, areaCode,pic, status, location,type);
		return publishData;
	}

	// 家族产业后台进入修改页面
	@RequestMapping(value = "/amend", method = RequestMethod.POST)
	@ApiOperation(value = "家族产业后台进入修改页面")
	// 文章ID writingsId
	public Response<SysWritingInfo> amend(@RequestParam("writingsId") String writingsId,HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//修改页面
		Response<SysWritingInfo> amend = SysFamilyBusinessService.amend(writingsId);
		return amend;
	}

	// 家族产业后台进入修改页面后发表或者草稿
	@RequestMapping(value = "/amendPublish", method = RequestMethod.POST)
	@ApiOperation(value = "家族产业后台进入修改页面后发表或者草稿")
	// 文章ID writingsId
	public Response<SysWritingInfo> amendPublish(@RequestParam("writingsId") String writingsId,
			@RequestParam("title") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, @RequestParam("location") String location, //具体产业地址
			@RequestParam("pic") String pic, @RequestParam("status") Integer status,
			@RequestParam("synopsis") String synopsis,//简介
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		// 插入数据
		Response<SysWritingInfo> amendPublish = SysFamilyBusinessService.amendPublish(writingsId, title, text, style,
				location, pic, status, synopsis);
		return amendPublish;
	}
}
