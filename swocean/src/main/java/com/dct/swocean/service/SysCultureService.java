package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.entity.SysZipaiInfo;

public interface SysCultureService {

	/**
	 * 家族文化分类展示
	 * 
	 * @param pageSize 当前页
	 * @param pageNow  每页显示条数
	 * @param style    分类
	 * @param userId   用户ID
	 * @return
	 */
	List<SysWritingInfo> culture(Integer pageSize, Integer pageNow, String style, String areaCode);

	/**
	 * 删除家族文化本县字派记录
	 * 
	 * @param zipaiId 字派ID
	 */
	void deleteCulture(String zipaiId);

	/**
	 * 修改家族文化本县字派记录
	 * 
	 * @param zipaiId     字派ID
	 * @param region      地区
	 * @param zipai_order 序列
	 */
	void updaleCulture(String zipaiId, String region, String zipaiOrder, String ancestorsName);

}
