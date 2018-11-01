package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysCelebrityInfo;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.service.SysFamilyOrganizationService;
import com.dct.swocean.util.Response;


/**
 * 
 * 家族联谊会名人组织机构后台
 */
@RestController
@RequestMapping("/organization")
@CrossOrigin(origins = "*") // 跨域
public class SysFamilyOrganizationController {

	@Autowired
	private SysFamilyOrganizationService sysFamilyOrganizationService;

	
	//家族组织机构后台文章分类查询
	@RequestMapping(value = "/typeQuerying", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> typeQuerying(
			@RequestParam("parentId") Integer parentId) {
		Response<SysRightinfoInfo> addClassify = sysFamilyOrganizationService.typeQuerying(parentId);
		return addClassify;
	}
	
	
	// 家族组织机构后台文章分类添加
	@RequestMapping(value = "/addClassify", method = RequestMethod.POST)
	public Response<SysRightinfoInfo> addClassify(@RequestParam("column") String column,
			@RequestParam("rightName") String rightName,// 文章分类名称
			@RequestParam(name="status",defaultValue="2") Integer status// 状态1不能删除2可以删除
     ) {
		Response<SysRightinfoInfo> addClassify = sysFamilyOrganizationService.addClassify(column, rightName,status);
		return addClassify;
	}
	
	// 家族组织机构后台文章分类删除
		@RequestMapping(value = "/deleteClassify", method = RequestMethod.POST)
		public Response<SysRightinfoInfo> deleteClassify(@RequestParam("rightId") String rightId) {
			// 跨域解决
			Response<SysRightinfoInfo> response = sysFamilyOrganizationService.deleteClassify(rightId);
			return response;
		}

	// 家族组织机构添加人物详细信息
	@RequestMapping(value = "/addFigure", method = RequestMethod.POST)
	public Response<SysCelebrityInfo> addFigure(
			@RequestParam("userId") String userId, 
		    @RequestParam("style") Integer style,  //名人职务ID     
		    @RequestParam("celebrityName") String celebrityName,//名人真实姓名
			@RequestParam("synopsis") String synopsis,//人物简介
			@RequestParam("familyName") String familyName, // 姓氏
			@RequestParam("areaCode") String areaCode, // areaCode 地区ID,
			@RequestParam("pic") String pic, 
			@RequestParam("status") Integer status) {
		// 插入数据
		Response<SysCelebrityInfo> addFigure = sysFamilyOrganizationService.addFigure(userId, style,celebrityName,synopsis, familyName, areaCode, pic, status);
		return addFigure;
	}
	
	// 家族组织机构名人详情
	@RequestMapping(value = "/backstage", method = RequestMethod.POST)
	public Response<SysCelebrityInfo> backstage(@RequestParam("celebrityId") String celebrityId) {
		// 查询
		Response<SysCelebrityInfo> backstage = sysFamilyOrganizationService.backstage(celebrityId);
		return backstage;
	}
	
	//家族组织机构名人进入修改页面
	@RequestMapping(value = "/updateBackstage", method = RequestMethod.POST)
	public Response<SysCelebrityInfo> updateBackstage(@RequestParam("celebrityId") String celebrityId) {
		// 查询
		Response<SysCelebrityInfo> backstage = sysFamilyOrganizationService.backstage(celebrityId);
		return backstage;
	}

	// 家族组织机构名人删除信息
	@RequestMapping(value = "/deleteBackstage", method = RequestMethod.POST)
	public Response<SysCelebrityInfo> deleteDraft(@RequestParam("celebrityId") String celebrityId) {
		Response<SysCelebrityInfo> details = sysFamilyOrganizationService.deletePublish(celebrityId);
		return details;
	}
	
	//家族组织机构名人分页查询
	@RequestMapping(value="/consult",method=RequestMethod.POST)
	public Response<CulturePage> consult(
			@RequestParam(value = "style") Integer style,       //名人职务ID
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "familyName") String familyName, // familyName 姓氏名称
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "status", defaultValue = "1") Integer status) {
		Response<CulturePage> culture = sysFamilyOrganizationService.culture(style, pageNow, pageSize, areaCode, familyName,status);
		return culture;
	}
		
}
