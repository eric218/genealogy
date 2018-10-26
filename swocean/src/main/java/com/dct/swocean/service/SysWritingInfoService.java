package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.common.FamilyCelebrity;
import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.common.RecordNotice;
import com.dct.swocean.entity.SysUserLoginInfo;
import com.dct.swocean.entity.SysWritingInfo;

public interface SysWritingInfoService {

	/**
	 * 增加数据库信息
	 * 
	 * @SysResult 返回是否成功
	 * @param title  标题
	 * @param text   内容
	 * @param style  分类
	 * @param userId 用户ID
	 * @return
	 */
	public void insertWriting(String title, String text, Integer style, String userId);

	/**
	 * 查询动态公告数据
	 * 
	 * @param style  分类
	 * @param userId 用户ID
	 * @return
	 */
	public List<RecordNotice> selectWriting(String style, String areaCode, String familyName);

	/**
	 * 查询最新发表数据
	 * 
	 * @param userId 用户ID
	 * @return
	 */
	public List<RecordNotice> newest(String areaCode, String familyName);

	/**
	 * 家族文化展示
	 * 
	 * @param pageSize 每页显示条数
	 * @param page     当前页
	 * @param style    分类
	 * @param userId   用户ID
	 * @return
	 */
	public CulturePage culture(Integer pageSize, Integer pageNow, String style, String userId);

	/**
	 * 家族产业 私人产业
	 * 
	 * @param userId 用户ID
	 * @param style  分类
	 */
	public List<FamilyIndustry> industry(String userId, String style);

	/**
	 * 家族产业 公共产业
	 * 
	 * @param userId 用户ID
	 * @param style  分类
	 */
	public List<FamilyIndustry> commonality(String userId, String style);

	/**
	 * 家族名人
	 * 
	 * @param userId 用户ID
	 * @param style  分类
	 */
	public FamilyCelebrity celebrity(String areaCode, String style, String name);

	/**
	 * 用户信息存储
	 * 
	 * @param userName 用户名
	 * @param message  发送的信息
	 */

	public void answer(String userName, String message);

	/**
	 * 查询用户的登录信息
	 * 
	 * @return
	 */
	public List<SysUserLoginInfo> userList();

	// 计数
	Long selectByType(String userId, String type, String status);

	// 日誌信息
	List<SysWritingInfo> select(String useId, String type, Integer pageNo, Integer pageSize, String status);

	// 说说新增
	void add(String userId, String region, String text, String type, String status);

	// 说说删除
	void delete(String writingId);

	// 日志草稿
	SysWritingInfo selectOne(String userId);

	// 日志修改之前的查询
	SysWritingInfo selectByWritingId(String userId, String writingId);

	// 修改日志
	void update(SysWritingInfo sysWritingInfo);

	// 日志新增
	void insert(SysWritingInfo sysWritingInfo);

	// 收益支出
	List<SysWritingInfo> selectPayLog(String style, String areaCode, Integer pageNo, Integer pageSize);

	
	List<SysWritingInfo> selectByTime(String style, String areaCode, Integer pageNo, Integer pageSize);
}
