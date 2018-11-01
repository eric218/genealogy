package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.dao.SysWritingInfoMapper2;
import com.dct.swocean.entity.SysCelebrityInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysPlCelebrityServices;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

/**
 * 省级家族名人
 * @author xiaohei
 *
 */
@RequestMapping("/PLCelebrity")
@Controller
public class SysPLCelebrityController {

	@Autowired
	private SysPlCelebrityServices sysPlCelebrityServices;
	
	@Autowired
	private SysWritingInfoMapper2 sysWritingInfoMapper;
	
	@ResponseBody
	@RequestMapping(value="/PLCelebrityWriting",method=RequestMethod.POST)
	//祖先名人文章发表
	public Response<SysWritingInfo> fabiao(SysWritingInfo SysWritingInfo){
		sysPlCelebrityServices.inser(SysWritingInfo);
		return ResponseUtlis.success("发表成功");
	}
	//祖先名人编辑前查询
	@ResponseBody
	@RequestMapping(value="/PLCelebritySelect",method=RequestMethod.POST)
	public Response<SysCelebrityInfo> chaxun(SysCelebrityInfo sysCelebrityInfo){
		sysPlCelebrityServices.select(sysCelebrityInfo);
		return ResponseUtlis.success("查询成功");
	}
	//祖先名人编辑
	@ResponseBody
	@RequestMapping(value="/PLCelebrityUpdate",method=RequestMethod.POST)
	public Response<SysCelebrityInfo> bianji(SysCelebrityInfo sysCelebrityInfo){
		sysPlCelebrityServices.update(sysCelebrityInfo);
		return ResponseUtlis.success("修改成功");
	}
}
