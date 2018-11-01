package com.dct.swocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.service.SysElectronSpectrumService;
import com.dct.swocean.util.Response;

@RestController
@RequestMapping("/numberGenealogy")
@CrossOrigin(origins = "*") // 跨域
public class SysElectronSpectrumController {

	@Autowired
	private SysElectronSpectrumService sysElectronSpectrumService;
	
	//电子谱查询
	@RequestMapping(value="/network")
	public Response<CulturePage> network(@RequestParam("netId") String netId, //网站ID
			@RequestParam("showPositionId") String showPositionId //类型
			) {
		Response<CulturePage> network=sysElectronSpectrumService.network(netId,showPositionId);
		return null;
	}
}
