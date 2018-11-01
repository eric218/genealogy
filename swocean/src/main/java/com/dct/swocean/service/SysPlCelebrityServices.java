package com.dct.swocean.service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysCelebrityInfo;
import com.dct.swocean.entity.SysWritingInfo;

/**
 * 家族名人
 * @author xiaohei
 *
 */
public interface SysPlCelebrityServices {
	/**
	 * 增加文章
	 * @param sysWritingInfo 
	 */
	void inser(SysWritingInfo sysWritingInfo);
	/**
	 * 家族名人编辑
	 * @param sysCelebrityInfo
	 */
	public void update(SysCelebrityInfo sysCelebrityInfo);
	/**
	 * 家族名人编辑前查询
	 */
	public void select(SysCelebrityInfo sysCelebrityInfo);
	/**
	 * 分页
	 * @param pageSize 每页总条数
	 * @param pageNow 当前页
	 * @param style 文章分类
	 * @param publisher 用户id
	 * @return
	 */
	public CulturePage culture(Integer pageSize, Integer pageNow, String style, String publisher);

	

}
