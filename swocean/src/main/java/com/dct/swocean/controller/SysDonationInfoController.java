package com.dct.swocean.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.entity.SysAccountInfo;
import com.dct.swocean.entity.SysDonationInfo;
import com.dct.swocean.service.SysAccountService;
import com.dct.swocean.service.SysDonationInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

@Controller
public class SysDonationInfoController {

	private final static Logger logger = LoggerFactory.getLogger(SysDonationInfoController.class);

	@Autowired
	private SysDonationInfoService donationService;

	@Autowired
	private SysAccountService sysAccountService;

	// 新增捐款流水
	@ResponseBody
	@RequestMapping(value = "/donation", method = RequestMethod.POST)
	public Response<SysDonationInfo> insert(@RequestParam("payAmount") BigDecimal payAmount,
			@RequestParam("creator") String creator) {
		//donationService.insert(payAmount, creator);
		sysAccountService.update(creator, payAmount);
		return ResponseUtlis.success("捐款成功");
	}

	/*// 查询捐款流水
	@ResponseBody
	@RequestMapping("/selectByPayTime")
	public List<SysDonationInfo> selectByPayTime() {
		return donationService.selectByPayTime();
	}*/

}
