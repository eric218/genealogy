package com.dct.swocean.service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.util.Response;

public interface SysFamilyBusinessService{
	
	
	
    /**
     *私有财产
     * @param userId  用户Id
     * @param style   分类
     * @param pageNow   当前页
     * @param pageSize  每页显示的条数
     * @param areaCode  地区ID
     * @param familyName  姓氏名称
     * @return
     */
	Response<CulturePage> industry(String userId, Integer style, Integer pageNow, Integer pageSize,String areaCode,String familyName,Integer status,String type);

	
	//********************************************************************************
	/**
	 * 公有财产
	 * @param userId  用户Id
     * @param style   分类
     * @param pageNow   当前页
     * @param pageSize  每页显示的条数
     * @param areaCode  地区ID
     * @param familyName  姓氏名称
	 * @return
	 */
	//CulturePage commonality(String userId, String style, Integer pageNow, Integer pageSize,String areaCode,String familyName);
	//********************************************************************************
	
	/**
	 *进入前台家族产业发表页面
     * @param column   栏目
     * @param areaCode  地区ID
     * @param familyName  姓氏名称
     * @param pageNow   当前页
     * @param pageSize  每页显示的条数
	 * @return 
	 */
	 Response<CulturePage> culturePublish( String column,String areaCode,
			String familyName,Integer pageNow,Integer pageSize,String type,Integer status);

	/**
	 * 进入前台家族产业发表页面详情
	 * @param writingsId 文章ID
	 */
	 SysWritingInfo detailsPublish(String writingsId);
	 
	/**
	 * 进入前台家族产业发表页面草稿删除
	 * 
	 * @param writingsId 文章ID
	 * @return
	 */
	Response<SysWritingInfo> deletePublish(String writingsId);
	
	/**
	 *增加收藏数
	 * @param writingsId 文章ID
	 */
	Response<SysWritingInfo> collect(String writingsId, String userId);

	/**
	 * 增加点赞数
	 * @param writingsId 文章ID
	 */
	void insertLike(String writingsId);

    /**
     * 查看详情增加查看数
     * @param writingsId 文章ID
     */
	Response<FamilyIndustry> selectParticulars(String writingsId);

	
	/**
	 * 家族产业后台文章分类查询
	 * @param parentId  类型分类父ID
	 * @return
	 */
	Response<SysRightinfoInfo> typeQuerying(Integer parentId);

	/**
	 * 家族产业后台文章分类添加
	 * @param column  分类栏目
	 * @param rightName  分类名称
	 */
	void addClassify(String column,String rightName);

	/**
	 * 家族产业后台文章分类删除
	 * @param rightName 分类名称
	 */
	Response<SysRightinfoInfo> deleteClassify(String rightName);

	/**
	 * 前台页面发表数据
	 * @param userId     用户ID
	 * @param title      标题
	 * @param text       内容
	 * @param style      文章分类
	 * @param familyName 姓氏名称
	 * @param areaCode   地区ID
	 * @param synopsis   姓氏名称
	 * @param pic        图片地址
	 * @param status     文章状态 发表 草稿
	 */
	Response<SysWritingInfo> publishData(String userId, String title, String text, Integer style,String synopsis, String familyName,String areaCode ,String pic,
			Integer status,String location,String type);
	
	/**
	 * 家族产业后台   公共产业
	 * @param userId  用户Id
     * @param style   分类
     * @param pageNow   当前页
     * @param pageSize  每页显示的条数
     * @param areaCode  地区ID
     * @param familyName  姓氏名称
	 * @return
	 */
	CulturePage backstageCommonality(String userId, Integer style, Integer pageNow, Integer pageSize, String areaCode,
			String familyName,String type);


	/**
	 * 家族产业后台查看详情  
	 * @param writingsId 文章ID
	 * @return
	 */
	FamilyIndustry backstage(String writingsId);

	/**
	 * 家族产业后台删除信息
	 * @param writingsId 文章ID
	 * @param status  文章状态1发表2删除0草稿
	 */
	Response<SysWritingInfo> deleteData(String writingsId, Integer status);


	/**
	 * 家族产业后台进入修改页面 
	 * @param writingsId 文章ID
	 * @return
	 */
	Response<SysWritingInfo> amend(String writingsId);


	/**
	 * 家族产业后台进入修改页面后发表或者草稿
	 *  @param writingsId 文章ID
	 * @param title 标题
	 * @param text  内容
	 * @param style 分类
	 * @param areaName 地址名称
	 * @param path     图片地址
	 * @param status   状态
	 * @param synopsis  简介
	 */
	Response<SysWritingInfo> amendPublish(String writingsId, String title, String text, Integer style, String location, String pic,
			Integer status,String synopsis);

	
    /**
                 * 家族产业前台发表页面上草稿删除
     * @param writingsId 文章ID
     */
	Response<SysWritingInfo> deleteDraft(String writingsId);


	


	

	

}
