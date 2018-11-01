package com.dct.swocean.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dct.swocean.common.Donor;
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
@CrossOrigin(origins = "*")
@RestController
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

	// 慈善基金
	@RequestMapping("/money")
	public Response<SysAccountInfo> selectByAreaCode(@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode) {

		SysAccountInfo sysAccountInfo = sysAccountService.selectByAreaCode(areaCode);
		return ResponseUtlis.success(sysAccountInfo);
	}

	// 基金概况
	// 基金支出
	@RequestMapping("/payLog")
	public Response<SysPayLogInfo> payLogInfo(@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
			@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {

		List<SysPayLogInfo> list = sysPayLogInfoService.selectByPayTime(areaCode, pageNo, pageSize);
		return ResponseUtlis.success(list);
	}

	// 基金捐赠
	@RequestMapping("/donation")
	public Response<SysDonationInfo> donationInfo(@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pagesize", defaultValue = "3") Integer pageSize) {

		List<Donor> donors = sysDonationInfoService.selectByPayTime(areaCode, pageNo - 1, pageSize);
		return ResponseUtlis.success(donors);
	}

	// 基金收入
	@RequestMapping("/donor")
	public Response<Donor> selectByDonor(@RequestParam(name = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pagesize", defaultValue = "3") Integer pageSize) {

		List<Donor> donorList = sysDonationInfoService.selectByDonor(areaCode, pageNo - 1, pageSize);
		return ResponseUtlis.success(donorList);
	}

	// 新增捐赠
	@RequestMapping(value = "insertDonation", method = RequestMethod.POST)
	public Response<SysDonationInfo> insertDonation() {
		return null;
	}

	// 發表
	@RequestMapping(value = "publish", method = RequestMethod.POST)
	public Response<SysPayLogInfo> selectPayLog(@RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
			@RequestParam(value = "style", defaultValue = "18") String style) {

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
	@RequestMapping(value = "insertPayLog", method = RequestMethod.POST)
	public Response<SysPayLogInfo> insertPayLog01(@RequestParam("payContent") String payContent, @RequestParam("payAmount") BigDecimal payAmount,
			/*
			 * @RequestParam(value = "style", defaultValue = "19") String style,
			 */ @RequestParam("creator") String creator,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		sysPayLogInfoService.insert(payAmount, payContent, creator, status);

		// 减少总基金
		// sysAccountService.up(creator, payAmount);
		return ResponseUtlis.success("发布成功");
	}

	// 基金提现
	@RequestMapping(value = "drowing", method = RequestMethod.POST)
	public Response<SysPayLogInfo> Drawing(SysDrowingInfo sysDrowingInfo) {

		// 新增提现流水
		sysDrowingService.insert(sysDrowingInfo);

		// 减少总基金
		sysAccountService.up(sysDrowingInfo.getDrowName(), sysDrowingInfo.getDrowAmount());
		return ResponseUtlis.success("提现成功");
	}

	// 提现记录
	@RequestMapping(value = "selectDrowing", method = RequestMethod.POST)
	public Response<SysDrowingInfo> selectDrowing(@RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {

		List<SysDrowingInfo> sysDrowingInfos = sysDrowingService.select(areaCode, pageNo - 1, pageSize);

		return ResponseUtlis.success(sysDrowingInfos);
	}

	// 草稿
	@RequestMapping(value = "draft", method = RequestMethod.POST)
	public Response<SysPayLogInfo> insertPayLog02(@RequestParam("payContent") String payContent, @RequestParam("payAmount") BigDecimal payAmount,
			/*
			 * @RequestParam(value = "style", defaultValue = "19") String style,
			 */ @RequestParam("creator") String creator,
			@RequestParam(value = "status", defaultValue = "0") String status) {

		sysPayLogInfoService.insert(payAmount, payContent, creator, status);

		return ResponseUtlis.success("保存草稿");
	}

	//财务支出
	@RequestMapping("expendInfo")
	public Response<SysWritingInfo> expendInfo(@RequestParam(value = "netId",defaultValue = "1")Integer netId,
											   @RequestParam(value = "news_column",defaultValue = "17")String news_column) {

		//sysWritingInfoService.
		return null;
	}

	//财务收入
	@RequestMapping("incomeInfo")
	public Response<SysWritingInfo> incomeInfo(@RequestParam(value = "netId",defaultValue = "1")Integer netId,
											   @RequestParam(value = "news_column",defaultValue = "17")String news_column) {

		//sysWritingInfoService.
		return null;
	}

	//
}
