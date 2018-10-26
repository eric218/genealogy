package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.service.SysIndustryService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

/**
 * 
 * 家族产业
 *
 */

@RestController
@RequestMapping("/columnIndustry")
@SuppressWarnings("unchecked")
public class SysIndustryController {
	
	@Autowired
	private SysIndustryService sysIndustryService;

	// 以上待 补充
	
	
	
	
	// 查询产业
	@RequestMapping("/commonality")
	public Response<CulturePage> commonality(@RequestParam("userId") String userId,
			@RequestParam(value="style",defaultValue="15") String style,
			@RequestParam(value = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize) {
		CulturePage culturePage=null;
		if(style.equals("15")) {
			//公有
			 culturePage = sysIndustryService.commonality(userId, style,pageNow,pageSize);
		}else {
			//私有
			// culturePage = sysIndustryService.industry(userId, style,pageNow,pageSize);
		}
		return ResponseUtlis.success(culturePage);
	}

	/*// 查询私人产业
	@RequestMapping("/person")
	public Response<CulturePage> person(@RequestParam("userId") String userId, 
			@RequestParam("style") String style,
			@RequestParam(name = "pageNow", defaultValue = "1") Integer pageNow,
			@RequestParam(name = "pageSize", defaultValue = "4") Integer pageSize) {
		
		return ResponseUtlis.success(culturePage);
	}*/

}
