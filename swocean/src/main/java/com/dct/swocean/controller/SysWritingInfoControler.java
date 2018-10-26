package com.dct.swocean.controller;

/**
 * 
 * 首页页面后台代码
 * 
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyCelebrity;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.common.RecordNotice;
import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.service.SysWritingInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/File")
@SuppressWarnings("unchecked")
public class SysWritingInfoControler {

	@Autowired
	private SysWritingInfoService sysWritingInfoService;

	// 进入到首页发表页面
	@RequestMapping("/Publish")
	public String FilePublish() {
		return "publish";
	}

	// 测试 进入登录页面
	@RequestMapping("/login")
	public String dd() {
		return "index";
	}

	// 插入数据**************要修改
	// *********************
	@RequestMapping(value = "/storage", method = RequestMethod.POST)
	public Response<SysUserInfo> storage(@RequestParam("tit") String title, @RequestParam("text") String text,
			@RequestParam("style") Integer style, @RequestParam("userId") String userId) {
		// HttpSession session = request.getSession();
		// Object user = session.getAttribute(publisher);
		sysWritingInfoService.insertWriting(title, text, style, userId);
		return ResponseUtlis.success("发表成功");
	}

	// 查询动态公告数据
	@RequestMapping("/recordPage")
	public Response<RecordNotice> recordPage(HttpServletResponse res, @RequestParam("style") String style,
			@RequestParam("userId") String userId) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		List<RecordNotice> recordList = new ArrayList<RecordNotice>();
		// recordList = sysWritingInfoService.selectWriting(style, userId);
		return ResponseUtlis.success(recordList);
	}

	// 查询最新数据
	@RequestMapping(value = "/newest", method = RequestMethod.POST)
	public Response<RecordNotice> newest(HttpServletResponse res, @RequestParam("userId") String userId) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");

		List<RecordNotice> noticeList = new ArrayList<RecordNotice>();
		noticeList = sysWritingInfoService.newest(userId, userId);
		return ResponseUtlis.success(noticeList);
	}

	// 查询家族文化数据
	@RequestMapping("/culture")
	public Response<CulturePage> culture(@RequestParam("userId") String userId, @RequestParam("style") String style,
			@RequestParam(name = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(name = "pageSize", defaultValue = "6") Integer pageSize, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		CulturePage culture = sysWritingInfoService.culture(pageSize, pageNow, style, userId);
		return ResponseUtlis.success(culture);
	}

	// 查询家族名人
	@RequestMapping("/celebrity")
	public Response<FamilyCelebrity> celebrity(@RequestParam("userId") String userId,
			@RequestParam("style") String style, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		FamilyCelebrity celebrity = sysWritingInfoService.celebrity(userId, style, userId);
		return ResponseUtlis.success(celebrity);
	}

	// 查询公共产业
	@RequestMapping("/commonality")
	public Response<FamilyIndustry> commonality(@RequestParam("userId") String userId,
			@RequestParam("style") String style, HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		List<FamilyIndustry> commonalityList = sysWritingInfoService.commonality(userId, style);
		return ResponseUtlis.success(commonalityList);
	}

	// 查询私人产业
	@RequestMapping("/person")
	public Response<SysUserInfo> person(@RequestParam("userId") String userId, @RequestParam("style") String style,
			HttpServletResponse res) {
		// 跨域解决
		res.setHeader("Access-Control-Allow-Origin", "*");
		List<FamilyIndustry> personList = sysWritingInfoService.industry(userId, style);
		return ResponseUtlis.success(personList);
	}
}
