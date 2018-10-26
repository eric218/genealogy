package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;

public interface SysIndustryService {

	/**
	 * 私有财产
	 * 
	 * @param userId   用户Id
	 * @param style    分类
	 * @param pageNow  当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */

	List<FamilyIndustry> industry(String style, String areaCode, String familyName);

	/**
	 * 公有财产
	 * 
	 * @param userId   用户ID
	 * @param style    分类
	 * @param pageNow  当前页
	 * @param pageSize 每页显示的条数
	 * @return
	 */
	CulturePage commonality(String userId, String style, Integer pageNow, Integer pageSize);

}
