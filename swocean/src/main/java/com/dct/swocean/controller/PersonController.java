package com.dct.swocean.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.common.FastDFSClient;
import com.dct.swocean.entity.PersonInfo;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysDonationInfo;
import com.dct.swocean.entity.SysUploadInfo;
import com.dct.swocean.entity.SysUserRegInof;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.service.SysAreaInfoService;
import com.dct.swocean.service.SysDonationInfoService;
import com.dct.swocean.service.SysUploadInfoService;
import com.dct.swocean.service.SysUserRegInfoService;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.service.SysZiPaiService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import io.swagger.annotations.Api;

@Api(value = "个人中心")
@RequestMapping("/user")
@Controller
public class PersonController {

	@Autowired
	private SysWritingInfoService sysWritingInfoService;

	@Autowired
	private SysUserRegInfoService sysUserRegInfoService;

	@Autowired
	private SysUploadInfoService sysUploadInfoService;

	@Autowired
	private SysZiPaiService sysZiPaiService;

	@Autowired
	private SysAreaInfoService sysAreaInfoService;

	@Autowired
	private SysDonationInfoService sysDonationInfoService;

	// 个人中心
	@ResponseBody
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public Response<SysUserRegInof> selectByUser(HttpServletResponse response, @RequestParam("userId") String userId,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "type1", defaultValue = "01") String type1,
			@RequestParam(value = "type2", defaultValue = "02") String type2,
			@RequestParam(value = "type3", defaultValue = "03") String type3,
			@RequestParam(value = "type4", defaultValue = "04") String type4,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysUserRegInof sysUserRegInof = sysUserRegInfoService.selectByUserId(userId);

		SysZipaiInfo sysZipaiInfo = sysZiPaiService.selectByUserId(userId);

		// 说说
		Long count3 = sysWritingInfoService.selectByType(userId, type3, status);
		List<SysWritingInfo> sysWritingInfos3 = sysWritingInfoService.select(userId, type3, pageNo - 1, 1, status);

		// 日志
		Long count4 = sysWritingInfoService.selectByType(userId, type4, status);
		List<SysWritingInfo> sysWritingInfos4 = sysWritingInfoService.select(userId, type4, pageNo - 1, 5, status);

		// 照片
		Long count1 = sysUploadInfoService.count(userId, type1, Integer.parseInt(status));
		List<SysUploadInfo> sysUploadInfoList1 = sysUploadInfoService.selectByUploadTime(userId, type1, pageNo - 1,
				pageSize, status);

		// 视频
		Long count2 = sysUploadInfoService.count(userId, type2, Integer.parseInt(status));
		List<SysUploadInfo> sysUploadInfoList2 = sysUploadInfoService.selectByUploadTime(userId, type2, pageNo - 1,
				pageSize, status);

		PersonInfo personInfo = new PersonInfo();
		personInfo.setSysUploadCountPhoto(count1);
		personInfo.setSysUploadCountVideo(count2);
		personInfo.setSysWritingCountStatus(count3);
		personInfo.setSysWritingCountLog(count4);

		personInfo.setSysUploadInfoPhoto(sysUploadInfoList1);
		personInfo.setSysUploadInfoVideo(sysUploadInfoList2);
		personInfo.setSysWritingInfoStatus(sysWritingInfos3);
		personInfo.setSysWritingInfoLog(sysWritingInfos4);

		personInfo.setSysUserRegInof(sysUserRegInof);
		personInfo.setSysZipaiInfo(sysZipaiInfo);

		return ResponseUtlis.success(personInfo);
	}

	// 根據ID查詢個人信息
	@ResponseBody
	@RequestMapping(value = "/selectByUserId", method = RequestMethod.POST)
	public Response<PersonInfo> selectByUserId(HttpServletResponse response, @RequestParam("userId") String userId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysUserRegInof sysUserRegInof = sysUserRegInfoService.selectByUserId(userId);
		SysZipaiInfo sysZipaiInfo = sysZiPaiService.selectByUserId(userId);

		PersonInfo personInfo = new PersonInfo();
		personInfo.setSysZipaiInfo(sysZipaiInfo);
		personInfo.setSysUserRegInof(sysUserRegInof);

		return ResponseUtlis.success(personInfo);
	}

	// 根据ID修改个人信息
	@ResponseBody
	@RequestMapping(value = "/updateByUserId", method = RequestMethod.POST)
	public Response<PersonInfo> updateByUserId(HttpServletResponse response, PersonInfo personInfo) throws Exception {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		FastDFSClient fastDFSClient = new FastDFSClient("E:\\swocean\\src\\test\\java\\fdfs_client.conf");
		String filepath = fastDFSClient.uploadFile(personInfo.getSysUserRegInof().getPic());

		SysUserRegInof sysUserRegInof = new SysUserRegInof();
		sysUserRegInof.setPic(filepath);
		personInfo.setSysUserRegInof(sysUserRegInof);

		sysUserRegInfoService.update(personInfo.getSysUserRegInof());
		sysZiPaiService.updateByUserId(personInfo.getSysZipaiInfo());
		return ResponseUtlis.success("修改成功");
	}

	// 日志
	@ResponseBody
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public Response<SysWritingInfo> selectLog(HttpServletResponse response,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "04") String type, @RequestParam("userId") String userId,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysWritingInfo> logList = sysWritingInfoService.select(userId, type, pageNo - 1, pageSize, status);
		return ResponseUtlis.success(logList);
	}

	// 说说
	@ResponseBody
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public Response<SysWritingInfo> selectStatus(HttpServletResponse response,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "03") String type, @RequestParam("userId") String userId,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysWritingInfo> statusList = sysWritingInfoService.select(userId, type, pageNo - 1, pageSize, status);
		return ResponseUtlis.success(statusList);
	}

	// 照片
	@ResponseBody
	@RequestMapping(value = "/photo", method = RequestMethod.POST)
	public Response<SysWritingInfo> selectPhont(HttpServletResponse response,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "01") String type, @RequestParam("userId") String userId,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysUploadInfo> photoList = sysUploadInfoService.selectByUploadTime(userId, type, pageNo - 1, pageSize,
				status);
		return ResponseUtlis.success(photoList);
	}

	// 視頻
	@ResponseBody
	@RequestMapping(value = "/video", method = RequestMethod.POST)
	public Response<SysWritingInfo> selectVideo(HttpServletResponse response,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "type", defaultValue = "02") String type, @RequestParam("userId") String userId,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysUploadInfo> videoList = sysUploadInfoService.selectByUploadTime(userId, type, pageNo - 1, pageSize,
				status);
		return ResponseUtlis.success(videoList);
	}

	// 查询最新一条数据
	@ResponseBody
	@RequestMapping(value = "selectLastOne", method = RequestMethod.POST)
	public Response<SysWritingInfo> selectLastOne(HttpServletResponse response,
			@RequestParam(value = "userId", defaultValue = "user2018093014268912") String userId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysWritingInfo sysWritingInfo = sysWritingInfoService.selectOne(userId);

		if (sysWritingInfo.getStatus() == 2) {
			return ResponseUtlis.success(sysWritingInfo);
		} else {
			return null;
		}
	}

	// 日志发布
	@ResponseBody
	@RequestMapping(value = "/addLog", method = RequestMethod.POST)
	public Response<SysWritingInfo> addLog(HttpServletResponse response,
			@RequestParam(value = "userId", defaultValue = "user2018093014268912") String userId,
			SysWritingInfo sysWritingInfo) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysAreaInfo sysAreaInfo = sysAreaInfoService.select(userId);
		String region = sysAreaInfo.getAreaCode();
		sysWritingInfo.setRegion(region);

		sysWritingInfoService.insert(sysWritingInfo);
		return ResponseUtlis.success("成功发布");
	}

	// 日志删除
	@ResponseBody
	@RequestMapping(value = "/deleteLog", method = RequestMethod.POST)
	public Response<SysWritingInfo> deleteLog(HttpServletResponse response,
			@RequestParam("writingId") String writingId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysWritingInfoService.delete(writingId);

		return ResponseUtlis.success("删除成功");
	}

	// 日誌修改之前的查詢
	@ResponseBody
	@RequestMapping(value = "/selectLog", method = RequestMethod.POST)
	public Response<SysWritingInfo> selectOne(HttpServletResponse response,
			@RequestParam(value = "userId", defaultValue = "user2018093014268912") String userId, String writingId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysWritingInfo sysWritingInfo = sysWritingInfoService.selectByWritingId(userId, writingId);
		return ResponseUtlis.success(sysWritingInfo);
	}

	// 日志修改
	@ResponseBody
	@RequestMapping(value = "/updateLog", method = RequestMethod.POST)
	public Response<SysWritingInfo> updateLog(HttpServletResponse response, SysWritingInfo sysWritingInfo) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysWritingInfoService.update(sysWritingInfo);

		return ResponseUtlis.success("修改成功");
	}

	// 说说发布
	@ResponseBody
	@RequestMapping(value = "/addStatus", method = RequestMethod.POST)
	public Response<SysWritingInfo> addStatus(HttpServletResponse response,
			@RequestParam(value = "userId", defaultValue = "user2018093014268912") String userId,
			@RequestParam(value = "status", defaultValue = "1") String status, String text,
			@RequestParam(value = "type", defaultValue = "03") String type) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysAreaInfo sysAreaInfo = sysAreaInfoService.select(userId);
		String region = sysAreaInfo.getAreaCode();

		sysWritingInfoService.add(userId, region, text, type, status);
		return ResponseUtlis.success("成功发布");
	}

	// 删除说说
	@ResponseBody
	@RequestMapping(value = "/deleteStatus", method = RequestMethod.POST)
	public Response<SysWritingInfo> deleteStatus(HttpServletResponse response,
			@RequestParam("writingId") String writingId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysWritingInfoService.delete(writingId);

		return ResponseUtlis.success("删除成功");
	}

	// 照片上传
	@ResponseBody
	@RequestMapping(value = "/uploadPhoto")
	public Response<SysUploadInfo> uploadPhoto(HttpServletResponse response,
			@RequestParam(value = "userId", defaultValue = "user2018093014268912") String userId,
			@RequestParam(value = "type", defaultValue = "01") String type, String name, String path,
			@RequestParam(value = "status", defaultValue = "1") Integer status) throws Exception {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		FastDFSClient fastDFSClient = new FastDFSClient("E:\\swocean\\src\\test\\java\\fdfs_client.conf");
		String pic = fastDFSClient.uploadFile(path);

		SysUploadInfo sysUploadInfo = new SysUploadInfo();
		sysUploadInfo.setFileName(name);
		sysUploadInfo.setFilePath(pic);
		sysUploadInfo.setFileType(type);
		sysUploadInfo.setUploadUser(userId);
		sysUploadInfo.setStatus(status);
		sysUploadInfoService.insert(sysUploadInfo);

		return ResponseUtlis.success("上传成功");
	}

	// 照片删除
	@ResponseBody
	@RequestMapping(value = "/deletePhoto", method = RequestMethod.POST)
	public Response<SysUploadInfo> deletePhoto(HttpServletResponse response, @RequestParam("fileId") String fileId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysUploadInfoService.updateStatusById(fileId);
		return ResponseUtlis.success("删除成功");
	}

	// 视频上传
	@ResponseBody
	@RequestMapping(value = "/uploadVideo")
	public Response<SysUploadInfo> uploadVideo(HttpServletResponse response,
			@RequestParam(value = "userId", defaultValue = "user2018093014268912") String userId,
			@RequestParam(value = "type", defaultValue = "02") String type, String name, String path,
			@RequestParam(value = "status", defaultValue = "1") Integer status) throws Exception {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		FastDFSClient fastDFSClient = new FastDFSClient("E:\\swocean\\src\\test\\java\\fdfs_client.conf");
		String pic = fastDFSClient.uploadFile(path);

		SysUploadInfo sysUploadInfo = new SysUploadInfo();
		sysUploadInfo.setFileName(name);
		sysUploadInfo.setFilePath(pic);
		sysUploadInfo.setFileType(type);
		sysUploadInfo.setUploadUser(userId);
		sysUploadInfo.setStatus(status);
		sysUploadInfoService.insert(sysUploadInfo);

		return ResponseUtlis.success("上传成功");
	}

	// 视频删除
	@ResponseBody
	@RequestMapping(value = "/deleteVideo", method = RequestMethod.POST)
	public Response<SysUploadInfo> deleteVideo(HttpServletResponse response, @RequestParam("fileId") String fileId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysUploadInfoService.updateStatusById(fileId);
		return ResponseUtlis.success("删除成功");
	}

	// 捐款记录
	@ResponseBody
	@RequestMapping(value = "donation", method = RequestMethod.POST)
	public Response<SysDonationInfo> selectDonation(HttpServletResponse response, @RequestParam("donor") String donor,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysDonationInfo> sysDonationInfoList = sysDonationInfoService.selectByName(donor, pageNo, pageSize);

		return ResponseUtlis.success(sysDonationInfoList);
	}
}
