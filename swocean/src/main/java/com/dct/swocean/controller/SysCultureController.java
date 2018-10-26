package com.dct.swocean.controller;

/**
 * 家族文化
 */

import org.springframework.beans.factory.annotation.Autowired;

/**
 *家族文化页面
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.service.SysCultureService;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

@RestController
@RequestMapping("/family")
@SuppressWarnings("unchecked")
public class SysCultureController {

	@Autowired
	private SysCultureService sysCultureService;

	// 待 补充

	// *******************大广告 待补充

	// 资讯 查询家族文化分类信息
	@RequestMapping("/consult")
	public Response<CulturePage> consult(@RequestParam("userId") String userId,
			// 21 是数据库sys_rightinfo 的right_id字段对应的sys_writing表的style字段
			@RequestParam(name = "style", defaultValue = "21") String style,
			@RequestParam(name = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(name = "pageSize", defaultValue = "4") Integer pageSize) {
		// CulturePage culture = sysCultureService.culture(pageSize, pageNow, style,
		// userId);
		// return ResponseUtlis.success(culture);\
		return null;
	}

	// 家族文化字派后台删除
	@RequestMapping("/deleteCulture")
	// zipaiId 字派ID
	public Response<SysZipaiInfo> deleteCulture(@RequestParam("zipaiId") String zipaiId) {
		sysCultureService.deleteCulture(zipaiId);
		return ResponseUtlis.success("删除成功");
	}

	// ******************待修改

	// 家族文化字派后台删除
	@RequestMapping("/updaleCulture")
	// zipaiId 字派ID
	public Response<SysZipaiInfo> updaleCulture(@RequestParam("zipaiId") String zipaiId,
			@RequestParam("region") String region, @RequestParam("zipaiOrder") String zipaiOrder,
			@RequestParam("ancestorsName") String ancestorsName) {
		sysCultureService.updaleCulture(zipaiId, region, zipaiOrder, ancestorsName);
		return ResponseUtlis.success("修改成功");
	}

	// 家族文化后台文章分类
	@RequestMapping("/insertCulture")
	public Response<SysZipaiInfo> insertCulture(@RequestParam("style") String style) {

		return ResponseUtlis.success("修改成功");
	}
}
