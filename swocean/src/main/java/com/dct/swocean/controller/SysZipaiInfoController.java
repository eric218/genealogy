package com.dct.swocean.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysFatherInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.entity.sysCommentInfo;
import com.dct.swocean.service.SysZiPaiService;
import com.dct.swocean.util.Response;


/**
 * 
 * 家族文化字派
 */
@RestController
@RequestMapping("/culture")
public class SysZipaiInfoController {
	@Autowired
	private SysZiPaiService sysZipaiInfoService;
	
	//家族字派信息查询
	@RequestMapping(value = "/character", method = RequestMethod.POST)
	public Response<CulturePage> character(@RequestParam("userId") String userId,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "status",defaultValue="1") Integer status, //状态1是发表 状态0是草稿 状态2不能显示表示已删除
			@RequestParam(value = "family") Integer family, //  姓氏ID
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culture = sysZipaiInfoService.culture(userId,status,pageNow, pageSize, areaCode, family);
		return culture;
	}
	//###########################发表页面  上####################################
	//家族字派发表页面显示草稿信息
	@RequestMapping(value = "/enterPublish", method = RequestMethod.POST)
	public Response<CulturePage> enterPublish(@RequestParam("userId") String userId,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "status",defaultValue="0") Integer status, //状态1是发表 状态0是草稿 状态2不能显示表示已删除
			@RequestParam(value = "family") Integer family, //  姓氏ID
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culture = sysZipaiInfoService.culture(userId,status,pageNow, pageSize, areaCode, family);
		return culture;
	}	
	
	//家族字派发表页面详情
	@RequestMapping(value = "/detailsPublish", method = RequestMethod.POST)
	public Response<SysZipaiInfo> detailsPublish (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> details = sysZipaiInfoService.details(zipaiId);
		return details;
	}
	
	//家族字派发表进入修改页面
	@RequestMapping(value = "/updatePublish", method = RequestMethod.POST)
	public Response<SysZipaiInfo> updatePublish (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> details = sysZipaiInfoService.details(zipaiId);
		return details;
	}
	
	//家族字派发表进入修改页面后发表
	@RequestMapping(value = "/updateAnnounce", method = RequestMethod.POST)
	public Response<SysZipaiInfo> announce  (
			@RequestParam(value="userId") String userId,    //用户ID
			@RequestParam(value="location")String location,//地区具体地址
			@RequestParam(value="ancestorsName")String ancestorsName, //祖先名
			@RequestParam(value="zipaiOrder")String zipaiOrder,       //字派序列
			@RequestParam(value = "family") Integer family, // familyName 姓氏名称
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value="status")String status,HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//发表信息
		Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
		return response;
	}
	
	//家族字派发表页面后删除
	@RequestMapping(value = "/deletePublish", method = RequestMethod.POST)
	public Response<SysZipaiInfo> deletePublish (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> details = sysZipaiInfoService.deletePublish(zipaiId);
		return details;
	}
	
	//家族字派发表信息
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	public Response<SysZipaiInfo> publish (
			@RequestParam(value="userId") String userId,    //用户ID
			@RequestParam(value="location")String location,//地区具体地址
			@RequestParam(value="ancestorsName")String ancestorsName, //祖先名
			@RequestParam(value="zipaiOrder")String zipaiOrder,       //字派序列
			@RequestParam(value = "family") Integer family, // familyName 姓氏名称
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value="status")String status,HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//发表信息
		Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
		return response;
	}
	//###########################发表页面    下####################################
	
	
	
	//家族字派搜索
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Response<CulturePage> search (@RequestParam(value="zipaiOrder")String zipaiOrder,
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//搜索信息
		 Response<CulturePage> search = sysZipaiInfoService.search(zipaiOrder,pageNow,pageSize);
		return search;
	}
	
	//家族字派收藏
	@RequestMapping(value = "/collect", method = RequestMethod.POST)
	public Response<SysZipaiInfo> collect (
			@RequestParam(value="zipaiId")String zipaiId,
			@RequestParam("userId") String userId,
			HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//收藏
		Response<SysZipaiInfo> response = sysZipaiInfoService.collect(zipaiId,userId);
		return response;
	}
	
	//家族字派点赞
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public Response<SysZipaiInfo> like(@RequestParam(value="zipaiId")String zipaiId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> response=sysZipaiInfoService.insertLike(zipaiId);
		return response;
	}
	
	//家族字派转发
	@RequestMapping(value = "/relay", method = RequestMethod.POST)
	public Response<SysZipaiInfo> relay(@RequestParam(value="zipaiId")String zipaiId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> response=sysZipaiInfoService.insertRelay(zipaiId);
		return response;
	}
	
	//进入家族字派父评论页面
	@RequestMapping(value = "/selectComment", method = RequestMethod.POST)
	public Response<sysCommentInfo> selectComment(@RequestParam(value="zipaiId")String zipaiId,HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<sysCommentInfo> response = sysZipaiInfoService.selectComment(zipaiId);
		return response;
	}
	
	// 家族字派评论页面显示子评论
	@RequestMapping(value = "/selectFather", method = RequestMethod.POST)
	public Response<SysFatherInfo> selectFather(
			@RequestParam(value = "fatherId") String fatherId, // 子评论ID
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysFatherInfo> response = sysZipaiInfoService.selectFather(fatherId);
		return response;
	}
	
	//家族字派父评论
	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public Response<sysCommentInfo> comment(
			@RequestParam(value="zipaiId")String zipaiId,
			@RequestParam(value="text")String text,
			@RequestParam(value="userId")String userId,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<sysCommentInfo> response=sysZipaiInfoService.comment(zipaiId,text,userId);
		return response;
	}
	
	//家族字派子评论
	@RequestMapping(value = "/father", method = RequestMethod.POST)
	public Response<SysFatherInfo> father(
			@RequestParam(value="fatherId")String fatherId,//子评论ID
			@RequestParam(value="text")String text,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysFatherInfo> response=sysZipaiInfoService.father(text,fatherId);
		return response;
	}

	//##############################后台页面#################################
	
	//家族字派后台页面信息查询
	@RequestMapping(value = "/backstage", method = RequestMethod.POST)
	public Response<CulturePage> backstage (@RequestParam("userId") String userId,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
	        //状态1是发表 状态0是草稿 状态2不能显示表示已删除
			@RequestParam(value = "family") Integer family, // 姓氏ID
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		 Response<CulturePage> backstage = sysZipaiInfoService.backstage(userId,pageNow, pageSize, areaCode, family);
		return backstage;
	}
	
	//**************************添加页面  上**********************************************
	//家族字派后台进入添加页面显示草稿页面
	@RequestMapping(value = "/backstagePublish", method = RequestMethod.POST)
	public Response<CulturePage> backstagePublish(@RequestParam("userId") String userId,
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value = "status",defaultValue="0") Integer status, //状态1是发表 状态0是草稿 状态2不能显示表示已删除
			@RequestParam(value = "family") Integer family, //  姓氏ID
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<CulturePage> culture = sysZipaiInfoService.culture(userId,status,pageNow, pageSize, areaCode, family);
		return culture;
	}
	
	//家族字派后台进入添加页面显示草稿页面详情
	@RequestMapping(value = "/backstageDetails", method = RequestMethod.POST)
	public Response<SysZipaiInfo> backstageDetails (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> details = sysZipaiInfoService.details(zipaiId);
		return details;
	}
	
	//家族字派后台进入添加页面显示草稿页面进入修改
	@RequestMapping(value = "/updateDetails", method = RequestMethod.POST)
	public Response<SysZipaiInfo> updateDetails (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
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
			@RequestParam(value = "family") Integer family, // familyName 姓氏名称
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value="status")String status,HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//发表信息
		Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
		return response;
	}
	
	//家族字派后台进入添加页面显示草稿页面删除
	@RequestMapping(value = "/deleteDetails", method = RequestMethod.POST)
	public Response<SysZipaiInfo> deleteDetails (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
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
			@RequestParam(value="status")String status,HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//发表信息
		Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
		return response;
	}
	//**************************添加页面  上**********************************************
	
	//家族字派后台信息的修改
	@RequestMapping(value = "/amendDetails", method = RequestMethod.POST)
	public Response<SysZipaiInfo> amendDetails (@RequestParam("zipaiId")String zipaiId, HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
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
			@RequestParam(value = "family") Integer family, // familyName 姓氏名称
			@RequestParam(value = "areaCode") String areaCode, // areaCode 地区ID
			@RequestParam(value="status")String status,HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		//发表信息
		Response<SysZipaiInfo> response = sysZipaiInfoService.publish(userId,location,ancestorsName,zipaiOrder,family,areaCode,status);
		return response;
	}
	
	//家族字派后台信息的删除
	@RequestMapping(value = "/removeDetails", method = RequestMethod.POST)
	public Response<SysZipaiInfo> removeDetails (@RequestParam("zipaiId")String zipaiId,
			@RequestParam("status")Integer status,
			HttpServletResponse res){
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		Response<SysZipaiInfo> details = sysZipaiInfoService.removeDetails(zipaiId,status);
		return details;
	}
	
}
