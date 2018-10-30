package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysFatherInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.entity.sysCommentInfo;
import com.dct.swocean.util.Response;

public interface SysZiPaiService {

	// 查询子派(姓氏)
	List<SysZipaiInfo> selectByFamilyName(String famliyname);

	// 查询子派(ID)
	SysZipaiInfo selectByUserId(String userId);

	// 修改子派(ID)
	void updateByUserId(SysZipaiInfo sysZipaiInfo);
	
	
	/**
	 * 家族字派信息查询
	 * @param userId 用户ID
	 * @param pageNow 当前页
     * @param pageSize 每页显示数据条数
     * @param status   状态1是发表 状态0是草稿 状态2不能显示表示已删除 
     * @param areaCode  地区ID
     * @param familyName 姓氏名称
     * @return
     */
	Response<CulturePage> culture(String userId,Integer status,Integer pageNow, Integer pageSize, String areaCode,
			String familyName);

	/**
	 * 家族字派发表信息
	 * @param userId 用户ID
	 * @param location 地区具体地址
	 * @param ancestorsName 祖先名
	 * @param zipaiOrder 字派序列
	 * @param familyName 姓氏名称
	 * @param areaCode 地区ID
	 * @param status  状态1是发表 状态0是草稿 状态2不能显示删除
	 */
	Response<SysZipaiInfo> publish(String userId, String location, String ancestorsName, String zipaiOrder, String familyName,
			String areaCode, String status);

	/**
	 * 家族字派搜索
	 * @param zipaiOrder 搜索
	 */
	Response<SysZipaiInfo> search(String zipaiOrder);

	/**
	 * 家族字派发表页面详情
	 * @param zipaiId 字派ID
	 */
	Response<SysZipaiInfo> details(String zipaiId);

	/**
	 * 家族字派发表页面后删除
	 * @param zipaiId 字派ID
	 * @return
	 */
	Response<SysZipaiInfo> deletePublish(String zipaiId);

	
	//############################## 家族文化字派前后页面#################################
	
	
	/**
	 * 家族字派后台页面信息查询
	 * @param userId 用户ID
	 * @param pageNow 当前页
     * @param pageSize 每页显示数据条数
     * @param areaCode  地区ID
     * @param familyName 姓氏名称
	 * @return
	 */
	Response<CulturePage> backstage(String userId, Integer pageNow, Integer pageSize, String areaCode, String familyName);

	/**
	 * 家族字派后台信息的删除
	 * @param zipaiId 字派ID
	 * @param status  状态
	 * @return
	 */
	Response<SysZipaiInfo> removeDetails(String zipaiId, Integer status);

	/**
	 * 家族字派收藏
	 * @param zipaiId 字派ID
	 * @param userId  用户ID
	 * @return
	 */
	Response<SysZipaiInfo> collect(String zipaiId, String userId);

	/**
	 * 家族字派点赞 
	 * @param zipaiId 字派ID
	 * @return
	 * 
	 */
	Response<SysZipaiInfo> insertLike(String zipaiId);

	/**
	 * 家族字派转发
	 * @param zipaiId 字派ID
	 * @return
	 */
	Response<SysZipaiInfo> insertRelay(String zipaiId);

	/**
	 * 进入家族字派评论父页面
	 * @param zipaiId 字派ID
	 * @return
	 */
	Response<sysCommentInfo> selectComment(String zipaiId);
	
	/**
	 * 家族字派评论子评论
	 * @param fatherId 子评论ID
	 * @return
	 */
	Response<SysFatherInfo> selectFather(String fatherId);
	
	/**
	 *家族字派父评论
	 * @param zipaiId 字派ID
	 * @param text    评论内容
	 * @param userId  评论用户ID
	 * @return
	 */
	Response<sysCommentInfo> comment(String zipaiId,String text,String userId);


	/**
	 * 家族字派子评论
	 * @param text    评论内容
	 * @param fatherId  子评论ID
	 * @return
	 */
	Response<SysFatherInfo> father(String text, String fatherId);

}
