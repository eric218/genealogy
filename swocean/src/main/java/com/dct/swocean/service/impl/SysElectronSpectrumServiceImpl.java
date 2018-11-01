package com.dct.swocean.service.impl;

import org.springframework.stereotype.Service;

import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.common.CulturePage;
import com.dct.swocean.service.SysElectronSpectrumService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
@Service
public class SysElectronSpectrumServiceImpl implements SysElectronSpectrumService {

	//返回状态码 成功 200
	private Integer SUCCESSFUL_CODE=ConstantClassField.SUCCESSFUL_CODE;
	//返回状态码 失败 500
	private Integer FAILURE_CODE=ConstantClassField.FAILURE_CODE;
	
	//电子谱查询
	@SuppressWarnings("unchecked")
	@Override
	public Response<CulturePage> network(String netId, String showPositionId) {
		try {
			
			return ResponseUtlis.error(SUCCESSFUL_CODE, "查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询错误");
		}
	}

}
