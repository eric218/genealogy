package com.dct.swocean.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *栏目之间跳转页面 
 *
 */

@RestController
@RequestMapping("/File")
@SuppressWarnings("unchecked")
public class PageSkipCortroller {
	
	//有可能修改 : 登录,注册
	
	
	// 登录
		@RequestMapping("/log")
		public String log() {
			return "log";
		}

		// 注册
		@RequestMapping("/register")
		public String register() {
			return "register";
		}

		// 首页
		@RequestMapping("/columnFirstPage")
		public String columnFirstPage() {
			return "columnFirstPage";
		}


		//*** 家族文化
		@RequestMapping("/columnCulture")
		public String columnCulture() {
			return "columnCulture";
		}

		// 慈善公益
		@RequestMapping("/columnCharity")
		public String columnCharity() {
			return "columnCharity";
		}

		// 家族产业
		@RequestMapping("/columnIndustry")
		public String columnIndustry() {
			return "columnIndustry";
		}

		// 家族名人
		@RequestMapping("/columnPerson")
		public String columnPerson() {
			return "columnPerson";
		}

		// 纪录家族
		@RequestMapping("/columnRecord")
		public String columnRecord () {
			return "columnRecord ";
		}

		// 统谱编修
		@RequestMapping("/columnCompile")
		public String columnCompile () {
			return "columnCompile ";
		}

}
