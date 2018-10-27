package com.dct.swocean.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Drawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.entity.Donor;
import com.dct.swocean.entity.SysAccountInfo;
import com.dct.swocean.entity.SysDonationInfo;
import com.dct.swocean.entity.SysDrowingInfo;
import com.dct.swocean.entity.SysPayLogInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysAccountService;
import com.dct.swocean.service.SysDonationInfoService;
import com.dct.swocean.service.SysDrowingService;
import com.dct.swocean.service.SysPayLogInfoService;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import io.swagger.annotations.Api;

@Api(value = "慈善公益")
@Controller
@RequestMapping("charity")
public class CharityController {

	@Autowired
	private SysDonationInfoService sysDonationInfoService;

	@Autowired
	private SysPayLogInfoService sysPayLogInfoService;

	@Autowired
	private SysAccountService sysAccountService;

	@Autowired
	private SysDrowingService sysDrowingService;

	@Autowired
	private SysWritingInfoService sysWritingInfoService;

	@RequestMapping("")
	public String demo() {
		return "charity";
	}

	// 慈善基金
	@ResponseBody
	@RequestMapping("/money")
	public Response<SysAccountInfo> selectByAreaCode(HttpServletResponse response,
			@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysAccountInfo sysAccountInfo = sysAccountService.selectByAreaCode(areaCode);
		return ResponseUtlis.success(sysAccountInfo);
	}

	// 基金概况
	// 基金支出
	@ResponseBody
	@RequestMapping("/payLog")
	public Response<SysPayLogInfo> payLogInfo(HttpServletResponse response,
			@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "pagesize", defaultValue = "5") Integer pageSize) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysPayLogInfo> list = sysPayLogInfoService.selectByPayTime(areaCode, pageNo, pageSize);
		return ResponseUtlis.success(list);
	}

	// 基金捐赠
	@ResponseBody
	@RequestMapping("/donation")
	public Response<SysDonationInfo> donationInfo(HttpServletResponse response,
			@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pagesize", defaultValue = "3") Integer pageSize) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<Donor> donors = sysDonationInfoService.selectByPayTime(areaCode, pageNo - 1, pageSize);
		return ResponseUtlis.success(donors);
	}

	// 基金收入
	@ResponseBody
	@RequestMapping("/donor")
	public Response<Donor> selectByDonor(HttpServletResponse response,
			@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pagesize", defaultValue = "3") Integer pageSize) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<Donor> donorList = sysDonationInfoService.selectByDonor(areaCode, pageNo - 1, pageSize);
		return ResponseUtlis.success(donorList);
	}

	// 新增捐赠
	@ResponseBody
	@RequestMapping(value = "insertDonation", method = RequestMethod.POST)
	public Response<SysDonationInfo> insertDonation() {
		return null;
	}

	// 發表
	@ResponseBody
	@RequestMapping(value = "publish", method = RequestMethod.POST)
	public Response<SysPayLogInfo> selectPayLog(HttpServletResponse response,
			@RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
			@RequestParam(value = "style", defaultValue = "18") String style) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysWritingInfo> sysWritingInfos = sysWritingInfoService.selectByTime(style, areaCode, pageNo, pageSize);
		SysWritingInfo sysWritingInfo = sysWritingInfos.get(0);

		// 判断是否为草稿
		if (sysWritingInfo.getStatus() == 0) {
			return ResponseUtlis.success(sysWritingInfo);
		} else {
			return ResponseUtlis.success(sysWritingInfo);
		}
	}

	
	// 发布成功
	@ResponseBody
	@RequestMapping(value = "insertPayLog", method = RequestMethod.POST)
	public Response<SysPayLogInfo> insertPayLog01(HttpServletResponse response,
			@RequestParam("payContent") String payContent, @RequestParam("payAmount") BigDecimal payAmount,
			/*
			 * @RequestParam(value = "style", defaultValue = "19") String style,
			 */ @RequestParam("creator") String creator,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysPayLogInfoService.insert(payAmount, payContent, creator, status);

		// 减少总基金
		// sysAccountService.up(creator, payAmount);
		return ResponseUtlis.success("发布成功");
	}

	// 基金提现
	@ResponseBody
	@RequestMapping(value = "drowing", method = RequestMethod.POST)
	public Response<SysPayLogInfo> Drawing(HttpServletResponse response, SysDrowingInfo sysDrowingInfo) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		// 新增提现流水
		sysDrowingService.insert(sysDrowingInfo);

		// 减少总基金
		sysAccountService.up(sysDrowingInfo.getDrowName(), sysDrowingInfo.getDrowAmount());
		return ResponseUtlis.success("提现成功");
	}

	// 提现记录
	@ResponseBody
	@RequestMapping(value = "selectDrowing", method = RequestMethod.POST)
	public Response<SysDrowingInfo> selectDrowing(HttpServletResponse response,
			@RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysDrowingInfo> sysDrowingInfos = sysDrowingService.select(areaCode, pageNo - 1, pageSize);

		return ResponseUtlis.success(sysDrowingInfos);
	}

	// 草稿
	@ResponseBody
	@RequestMapping(value = "draft", method = RequestMethod.POST)
	public Response<SysPayLogInfo> insertPayLog02(HttpServletResponse response,
			@RequestParam("payContent") String payContent, @RequestParam("payAmount") BigDecimal payAmount,
			/*
			 * @RequestParam(value = "style", defaultValue = "19") String style,
			 */ @RequestParam("creator") String creator,
			@RequestParam(value = "status", defaultValue = "0") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysPayLogInfoService.insert(payAmount, payContent, creator, status);

		return ResponseUtlis.success("保存草稿");
	}
}
