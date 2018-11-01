package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysFatherInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.entity.sysCommentInfo;
import com.dct.swocean.service.SysZiPaiService;
import com.dct.swocean.util.Response;

@RequestMapping("/examine")
@RestController
@CrossOrigin(origins = "*") //跨域
public class SysProvincialZiPaiController {

	@Autowired
	
	private SysZiPaiService sysZipaiInfoService;
	
	//省级家族字派信息查询
		@RequestMapping(value = "/character", method = RequestMethod.POST)
		public Response<CulturePage> character(@RequestParam("userId") String userId,
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
				@RequestParam(value = "status",defaultValue="1") Integer status, //状态1是发表 状态0是草稿 状态2不能显示表示已删除
				@RequestParam(value = "family") Integer family, // 姓氏ID
				@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
				@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
			Response<CulturePage> culture = sysZipaiInfoService.culture(userId,status,pageNow, pageSize, areaCode, family);
			return culture;
		}
		
		//省级家族字派模糊搜索
		@RequestMapping(value = "/search", method = RequestMethod.POST)
		public Response<CulturePage> search (@RequestParam(value="zipaiOrder")String zipaiOrder,
				@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
				@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize){
			//搜索信息
			 Response<CulturePage> search = sysZipaiInfoService.search(zipaiOrder,pageNow,pageSize);
			return search;
		}
		
		//省级地区选择下拉框
		@RequestMapping(value = "/county", method = RequestMethod.POST)
		public Response<SysConstantInfo> county (@RequestParam(value="areaCode")String areaCode, //省级ID
				@RequestParam(value="family")String family//姓氏ID
				){
			//搜索信息
			Response<SysConstantInfo> county = sysZipaiInfoService.county(areaCode,family);
			return county;
		}
		
		//省级地区选择下拉框地区字派查询
		@RequestMapping(value = "/selectCounty", method = RequestMethod.POST)
		public Response<CulturePage> selectCounty (@RequestParam(value="areaCode")String areaCode, //县级ID
				@RequestParam(value="family")String family, //姓氏ID
				@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
				@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
				@RequestParam(value="status")Integer status){
			//搜索信息
			Response<CulturePage> selectCounty = sysZipaiInfoService.selectCounty(areaCode,family,status,pageNow,pageSize);
			return selectCounty;
		}
		
		//家族字派收藏
		@RequestMapping(value = "/collect", method = RequestMethod.POST)
		public Response<SysZipaiInfo> collect (
				@RequestParam(value="zipaiId")String zipaiId,
				@RequestParam("userId") String userId){
			//收藏
			Response<SysZipaiInfo> response = sysZipaiInfoService.collect(zipaiId,userId);
			return response;
		}
		
		//家族字派点赞
		@RequestMapping(value = "/like", method = RequestMethod.POST)
		public Response<SysZipaiInfo> like(@RequestParam(value="zipaiId")String zipaiId) {
			Response<SysZipaiInfo> response=sysZipaiInfoService.insertLike(zipaiId);
			return response;
		}
		
		//家族字派转发
		@RequestMapping(value = "/relay", method = RequestMethod.POST)
		public Response<SysZipaiInfo> relay(@RequestParam(value="zipaiId")String zipaiId) {
			Response<SysZipaiInfo> response=sysZipaiInfoService.insertRelay(zipaiId);
			return response;
		}
		
		//进入家族字派父评论页面
		@RequestMapping(value = "/selectComment", method = RequestMethod.POST)
		public Response<sysCommentInfo> selectComment(@RequestParam(value="zipaiId")String zipaiId){
			Response<sysCommentInfo> response = sysZipaiInfoService.selectComment(zipaiId);
			return response;
		}
		
		// 家族字派评论页面显示子评论
		@RequestMapping(value = "/selectFather", method = RequestMethod.POST)
		public Response<SysFatherInfo> selectFather(
				@RequestParam(value = "fatherId") String fatherId // 子评论ID
				) {
			Response<SysFatherInfo> response = sysZipaiInfoService.selectFather(fatherId);
			return response;
		}
		
		//家族字派父评论
		@RequestMapping(value = "/comment", method = RequestMethod.POST)
		public Response<sysCommentInfo> comment(
				@RequestParam(value="zipaiId")String zipaiId,
				@RequestParam(value="text")String text,
				@RequestParam(value="userId")String userId) {
			Response<sysCommentInfo> response=sysZipaiInfoService.comment(zipaiId,text,userId);
			return response;
		}
		
		//家族字派子评论
		@RequestMapping(value = "/father", method = RequestMethod.POST)
		public Response<SysFatherInfo> father(
				@RequestParam(value="fatherId")String fatherId,//子评论ID
				@RequestParam(value="text")String text) {
			Response<SysFatherInfo> response=sysZipaiInfoService.father(text,fatherId);
			return response;
		}

		//家族字派后台进入添加页面显示草稿页面
		@RequestMapping(value = "/backstagePublish", method = RequestMethod.POST)
		public Response<CulturePage> backstagePublish(@RequestParam("userId") String userId,
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
				@RequestParam(value = "status",defaultValue="0") Integer status, //状态1是发表 状态0是草稿 状态2不能显示表示已删除
				@RequestParam(value = "family") Integer family, //  姓氏ID
				@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
				@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
			Response<CulturePage> culture = sysZipaiInfoService.culture(userId,status,pageNow, pageSize, areaCode, family);
			return culture;
		}
		
		//家族字派后台进入添加页面显示草稿页面详情
		@RequestMapping(value = "/backstageDetails", method = RequestMethod.POST)
		public Response<SysZipaiInfo> backstageDetails (@RequestParam("zipaiId")String zipaiId){
			Response<SysZipaiInfo> details = sysZipaiInfoService.details(zipaiId);
			return details;
		}
		
		//家族字派后台进入添加页面显示草稿页面进入修改
		@RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
		public Response<SysZipaiInfo> updateDetails (@RequestParam("zipaiId")String zipaiId){
			Response<SysZipaiInfo> details = sysZipaiInfoService.details(zipaiId);
			return details;
		}
		
		//家族字派后台进入添加页面显示草稿页面进入修改发表或者草稿
		@RequestMapping(value = "/addAnnounce", method = RequestMethod.POST)
		public Response<SysZipaiInfo> addAnnounce  (
				@RequestParam(value="userId") String userId,    //用户ID
				@RequestParam(value="location")String location,//地区具体地址
				@RequestParam(value="ancestorsName")String ancestorsName, //祖先名
				@RequestParam(value="zipaiOrder")String zipaiOrder,       //字派序列
				@RequestParam(value = "family") Integer family, // 姓氏名称
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
				@RequestParam(value="status")String status){
			//发表信息
			Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
			return response;
		}
		
		//家族字派后台进入添加页面显示草稿页面删除
		@RequestMapping(value = "/deleteDetails", method = RequestMethod.POST)
		public Response<SysZipaiInfo> deleteDetails (@RequestParam("zipaiId")String zipaiId){
			Response<SysZipaiInfo> details = sysZipaiInfoService.deletePublish(zipaiId);
			return details;
		}
		
		//家族字派后台进入添加页面发表还是草稿
		@RequestMapping(value = "/addPublish", method = RequestMethod.POST)
		public Response<SysZipaiInfo> addPublish (
				@RequestParam(value="userId") String userId,    //用户ID
				@RequestParam(value="location")String location,//地区具体地址
				@RequestParam(value="ancestorsName")String ancestorsName, //祖先名
				@RequestParam(value="zipaiOrder")String zipaiOrder,       //字派序列
				@RequestParam(value = "family") Integer family, // familyName 姓氏名称
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
				@RequestParam(value="status")String status){
			//发表信息
			Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
			return response;
		}
		
		//家族字派后台页面信息查询
		@RequestMapping(value = "/backstage", method = RequestMethod.POST)
		public Response<CulturePage> backstage (@RequestParam("userId") String userId,
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
		        //状态1是发表 状态0是草稿 状态2不能显示表示已删除
				@RequestParam(value = "family") Integer family, // 姓氏ID
				@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
				@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {;
			 Response<CulturePage> backstage = sysZipaiInfoService.backstage(userId,pageNow, pageSize, areaCode, family);
			return backstage;
		}
		
		//家族字派后台信息的修改
		@RequestMapping(value = "/amendDetails", method = RequestMethod.POST)
		public Response<SysZipaiInfo> amendDetails (@RequestParam("zipaiId")String zipaiId){
			Response<SysZipaiInfo> details = sysZipaiInfoService.details(zipaiId);
			return details;
		}
		
		//家族字派后台信息的修改后发表或者保存草稿
		@RequestMapping(value = "/amendAnnounce", method = RequestMethod.POST)
		public Response<SysZipaiInfo> amendAnnounce  (
				@RequestParam(value="userId") String userId,    //用户ID
				@RequestParam(value="location")String location,//地区具体地址
				@RequestParam(value="ancestorsName")String ancestorsName, //祖先名
				@RequestParam(value="zipaiOrder")String zipaiOrder,       //字派序列
				@RequestParam(value = "family") Integer family, // 姓氏名称
				@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
				@RequestParam(value="status")String status){
			//发表信息
			Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
			return response;
		}
		
		//家族字派后台信息的删除
		@RequestMapping(value = "/removeDetails", method = RequestMethod.POST)
		public Response<SysZipaiInfo> removeDetails (@RequestParam("zipaiId")String zipaiId,
				@RequestParam("status")Integer status){
			Response<SysZipaiInfo> details = sysZipaiInfoService.removeDetails(zipaiId,status);
			return details;
		}
}
