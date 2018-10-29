package com.dct.swocean.service;


import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.util.Response;

public interface SysFamilyCultureService {

	
	/**
	 * 家族文化分类展示
	 * @param pageSize 当前页
	 * @param pageNow  每页显示条数
	 * @param style    分类
	 * @param userId   用户ID
	 * @return
	 */
	Response<CulturePage> culture(String userId, Integer style, Integer pageNow, Integer pageSize, String areaCode,
			String familyName,Integer status,String type);

	/**
	 * 前台草稿详情
	 * @param writingsId 文章ID
	 * @return
	 */
	SysWritingInfo detailsPublish(String writingsId);
	
	//***************************************
	
	/**
	 * 删除家族文化本县字派记录
	 * @param zipaiId 字派ID
	 */
	void deleteCulture(String zipaiId);

	
	/**
	 *  家族文化后台文章分类查询
	 * @param parentId  类型分类父ID
	 * @return
	 */
	Response<SysRightinfoInfo> typeQuerying(Integer parentId);
	
	
    /**
     * 家族文化后台文章分类添加
     * @param column  分类的栏目
     * @param rightName
     */
	void addClassify(String column, String rightName);

	//***************************************
	
	/**
	 * 前台增加收藏数
	 * @param writingsId 文章ID
	 * @param userId 用户ID
	 */
	Response<SysWritingInfo> insertCollection(String writingsId,String userId);

	/**
	 * 前台增加点赞
	 * @param writingsId 文章ID
	 */
	void insertLike(String writingsId);

	/**
	 * 前台查看详情增加查看数
	 * @param writingsId 文章ID
	 * @return
	 */
	FamilyIndustry selectParticulars(String writingsId);

	/**
	 * 进入前台家族产业发表页面显示草稿信息
	 * @param userId  用户ID
	 * @param column  栏目
	 * @param areaCode 地址ID
	 * @param familyName 姓氏名称
	 * @return
	 */
	Response<CulturePage> culturePublish(String userId, String column, String areaCode, String familyName,Integer pageNow, Integer pageSize,String type,Integer status);

	/**
	 * 前台家族文化发表页面草稿删除
	 * @param writingsId 文章ID
	 * @return
	 */
	Response<SysWritingInfo> deletePublish(String writingsId);
	
	/**
	 * 前台页面发表数据
	 * @param userId     用户ID
	 * @param title      标题
	 * @param text       内容
	 * @param style      文章分类
	 * @param familyName 姓氏名称
	 * @param synopsis   姓氏名称
	 * @param pic        图片地址
	 * @param status     文章状态 发表 草稿
	 */
	Response<SysWritingInfo> publishData(String userId, String title, String text, Integer style,String synopsis, String familyName,String areaCode, String pic,
			Integer status,Integer type);
	
	/**
	 * 家族产业后台文章分类删除
	 * @param rightName 分类名称
	 */
	Response<SysRightinfoInfo> deleteClassify(int rightId);

	/**
	 * 家族文化后台信息查询
	 * @param userId 用户ID
	 * @param style  文章分类
	 * @param pageNow 当前页
	 * @param pageSize 每页显示的数据
	 * @param areaCode 地区ID
	 * @param familyName 姓氏名称
	 * @return
	 */
	CulturePage backstageCommonality(String userId, Integer style, Integer pageNow, Integer pageSize, String areaCode,
			String familyName);

	
	/**
	 * 家族产业后台查看详情
	 * @param writingsId 文章ID
	 * @return
	 */
	FamilyIndustry backstage(String writingsId);

	/**
	 * 家族文化后台进入修改页面
	 * @param writingsId 文章ID
	 * @return
	 */
	SysWritingInfo amend(String writingsId);

	/**
	 *  家族产业后台进入修改页面后发表或者草稿
	 * @param writingsId 文章ID
	 * @param title  标题
	 * @param text   内容
	 * @param style  文章分类
	 * @param pic    图片地址
	 * @param synopsis  简介
	 * @param status 状态1发表0草稿
	 */
	Response<SysWritingInfo> amendPublish(String writingsId, String title, String text, Integer style,String pic,
			Integer status,String synopsis);

	/**
	 * 家族文化后台文章数据删除
	 * @param writingsId 文章ID
	 */
	Response<SysWritingInfo> deleteData(String writingsId);

	
	
	
}
