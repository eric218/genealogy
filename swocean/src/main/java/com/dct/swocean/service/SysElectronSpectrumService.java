package com.dct.swocean.service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.util.Response;

public interface SysElectronSpectrumService {

	/**
	 * 电子谱查询
	 * @param netId 网站ID
	 * @param showPositionId 类型
	 * @return
	 */
	Response<CulturePage> network(String netId, String showPositionId);

}
