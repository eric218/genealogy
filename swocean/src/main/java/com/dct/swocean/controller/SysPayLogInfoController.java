package com.dct.swocean.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Controller
public class SysPayLogInfoController {

	private final static Logger logger = LoggerFactory.getLogger(SysPayLogInfoController.class);

	@Autowired
	private SysPayLogInfoService service;

	@Autowired
	private SysAccountService sysAccountService;

	@RequestMapping("/payment")
	public String insert() {
		return "payment";
	}

	// 支出流水
	@ResponseBody
	@RequestMapping(value = "/payLog", method = RequestMethod.POST)
	public Response<SysPayLogInfo> payLog(@RequestParam("payAccount") BigDecimal payAccount,
			@RequestParam("payContent") String payContent, @RequestParam("creator") String creator,
			HttpServletResponse response) {
		//service.insert(payAccount, payContent, creator);
		sysAccountService.up(creator, payAccount);

		try {
			response.sendRedirect("/selectAll");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResponseUtlis.success("发布成功");
	}

	/*// 查询支出流水
	@ResponseBody
	@RequestMapping("/selectAll")
	public Response<SysPayLogInfo> selectByPayTime() {
		List<SysPayLogInfo> sysPayLogInfos = service.selectByPayTime();
		return ResponseUtlis.success(sysPayLogInfos);
	}*/
}
