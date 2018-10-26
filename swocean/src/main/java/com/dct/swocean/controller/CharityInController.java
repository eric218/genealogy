package com.dct.swocean.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.entity.SysPayLogInfo;
import com.dct.swocean.service.SysAccountService;
import com.dct.swocean.service.SysPayLogInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import io.swagger.annotations.Api;

@Api(value = "慈善公益后台")
@Controller
@RequestMapping("charityIn")
public class CharityInController {

	@Autowired
	private SysPayLogInfoService sysPayLogInfoService;

	@Autowired
	private SysAccountService sysAccountService;

	// 發表
	@ResponseBody
	@RequestMapping(value = "publish", method = RequestMethod.POST)
	public Response<SysPayLogInfo> selectPayLog(HttpServletResponse response,
			@RequestParam(value = "areaCode", defaultValue = "420115") String areaCode,
			@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		List<SysPayLogInfo> list = sysPayLogInfoService.selectByPayTime(areaCode, pageNo - 1, pageSize);
		SysPayLogInfo sysPayLogInfo = list.get(0);

		// 判断是否为草稿
		if (sysPayLogInfo.getStatus() == 0) {
			return ResponseUtlis.success(sysPayLogInfo);
		} else {
			return ResponseUtlis.success(sysPayLogInfo);
		}
	}

	// 修改
	// 查询
	@ResponseBody
	@RequestMapping(value = "selectByPayId", method = RequestMethod.POST)
	public Response<SysPayLogInfo> selectByPayId(HttpServletResponse response, @RequestParam("payId") String payId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		SysPayLogInfo sysPayLogInfo = sysPayLogInfoService.selectByPayId(payId);
		return ResponseUtlis.success(sysPayLogInfo);
	}

	// 修改
	@ResponseBody
	@RequestMapping(value = "updateByPayId", method = RequestMethod.POST)
	public Response<SysPayLogInfo> updateByPayId(HttpServletResponse response, @RequestParam("payId") String payId,
			@RequestParam("payContent") String payContent, @RequestParam("payAmount") BigDecimal payAmount,
			@RequestParam("creator") String creator,
			@RequestParam(value = "status", defaultValue = "1") String status) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysPayLogInfoService.update(payContent, payAmount, creator, payId);
		return ResponseUtlis.success("修改成功");
	}

	// 删除
	@ResponseBody
	@RequestMapping(value = "deleteByPayId", method = RequestMethod.POST)
	public Response<SysPayLogInfo> deleteByPayId(HttpServletResponse response, @RequestParam("payId") String payId) {

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		sysPayLogInfoService.deleteByPayId(payId);
		return ResponseUtlis.success("刪除成功");
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
		sysAccountService.up(creator, payAmount);
		return ResponseUtlis.success("发布成功");
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
