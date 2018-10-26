package com.dct.swocean.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.service.SysUserLoginService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

@Controller
public class SysUserLoginController {

	@Autowired
	private SysUserLoginService sysUserLoginService;

	// 根據用戶名查詢用戶信息
	@ResponseBody
	@RequestMapping("/user")
	public Response<SysUserLoginInfo> selectById(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletResponse response) {
		SysUserLoginInfo sysUserLoginInfo = sysUserLoginService.selectByUserId(username);

		// 跨域解决
		response.setHeader("Access-Control-Allow-Origin", "*");

		// 判斷對象是否為空
		if (!StringUtils.isEmpty(sysUserLoginInfo)) {
			if (sysUserLoginInfo.getPassword().equals(password)) {
				return ResponseUtlis.success(sysUserLoginInfo);
			} else {
				return ResponseUtlis.error(400, "用户名或密码错误");
			}
		} else {
			return ResponseUtlis.error(500, "用户名不存在");
		}
	}
}
