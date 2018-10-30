package com.dct.swocean.service;

import com.dct.swocean.common.CulturePage;
import com.dct.swocean.entity.SysCelebrityInfo;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.util.Response;

public interface SysFamilyOrganizationService {

	/**
	 * 家族组织机构后台文章分类查询
	 * @param parentId  类型分类父ID
	 * @return
	 */
	Response<SysRightinfoInfo> typeQuerying(Integer parentId);
	
	
	/**
	 * 家族组织机构后台文章分类添加
	 * @param column    栏目编号 对应sys_rightinfo的right_id
	 * @param rightName 添加名称  对应sys_rightinfo的right_name
	 */
	Response<SysRightinfoInfo> addClassify(String column, String rightName,Integer status);

	/**
	 * 家族组织机构后台文章分类删除
	 * @param rightId 分类编号 sys_rightinfo表
	 * @return
	 */
	Response<SysRightinfoInfo> deleteClassify(String rightId);

	/**
	 * 家族组织机构添加人物
	 * @param userId  用户ID
	 * @param style   名人职务id
	 * @param celebrityName  名人真实名称
	 * @param synopsis      简介
	 * @param familyName    名人姓氏
	 * @param areaCode      地区ID
	 * @param pic          名人头像
	 * @param status       状态1发表2删除
	 */
	Response<SysCelebrityInfo> addFigure(String userId, Integer style, String celebrityName, String synopsis, String familyName,
			String areaCode, String pic, Integer status);

	/**
	 * 家族组织机构查看详情
	 * @param celebrityId 名人ID
	 * @return
	 */
	Response<SysCelebrityInfo> backstage(String celebrityId);

	/**
	 * 家族组织机构删除信息
	 * @param celebrityId 名人ID
	 * @return
	 */
	Response<SysCelebrityInfo> deletePublish(String celebrityId);

	/**
	 * 家族组织机构名人分页查询
	 * @param style    名人职务ID
	 * @param pageNow 当前页
	 * @param pageSize 每页显示条数
	 * @param areaCode 地区ID
	 * @param familyName 姓氏名称
	 * @param status    状态1表示发表2表示已删除
	 * @return
	 */
	Response<CulturePage> culture(Integer style, Integer pageNow, Integer pageSize, String areaCode, String familyName,
			Integer status);

	

}
