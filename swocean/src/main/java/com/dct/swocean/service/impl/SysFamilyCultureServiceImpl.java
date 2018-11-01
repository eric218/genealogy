package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.common.IDUtils;
import com.dct.swocean.dao.FamilyIndustryMapper;
import com.dct.swocean.dao.SysAreaInfoMapper;
import com.dct.swocean.dao.SysCollectInfoMapper;
import com.dct.swocean.dao.SysConstantInfoMapper;
import com.dct.swocean.dao.SysRightinfoInfoMapper;
import com.dct.swocean.dao.SysUserRegInofMapper;
import com.dct.swocean.dao.SysWritingInfoMapper;
import com.dct.swocean.dao.SysZipaiInfoMapper;
import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.entity.SysUserRegInof;
import com.dct.swocean.entity.SysWritingInfo;
import com.dct.swocean.service.SysFamilyCultureService;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import com.dct.swocean.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@SuppressWarnings("unchecked")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysFamilyCultureServiceImpl implements SysFamilyCultureService {

	@Autowired
	private SysAreaInfoMapper sysAreaInfoMapper;
	@Autowired
	private FamilyIndustryMapper familyIndustryMapper;
	@Autowired
	private SysZipaiInfoMapper sysZipaiInfoMapper;
	@Autowired
	private SysRightinfoInfoMapper sysRightinfoInfoMapper;
	@Autowired
	private SysWritingInfoMapper sysWritingInfoMapper;
	@Autowired
	private SysUserRegInofMapper sysUserRegInofMapper;
	@Autowired
	private SysConstantInfoMapper sysConstantInfoMapper;
	@Autowired
	private SysCollectInfoMapper sysCollectInfoMapper;
	
	//返回状态码 成功 200
	private Integer SUCCESSFUL_CODE=ConstantClassField.SUCCESSFUL_CODE;
	//返回状态码 失败 500
	private Integer FAILURE_CODE=ConstantClassField.FAILURE_CODE;
	//返回状态码 错误 400
	private Integer ERRO_CODE=ConstantClassField.ERRO_CODE;

	// 家族文化分类展示
	@Override
	public Response<CulturePage> culture(String userId, Integer style, Integer pageNow, Integer pageSize, String areaCode,
			String familyName,Integer status,String type) {
		try {
			// 查询出姓氏ID
			String sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
			SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
			// 开始分页
			PageHelper.startPage(pageNow, pageSize);
			// status状态1是发表 状态0是草稿
			sql = "SELECT w.* FROM sys_writing w WHERE w.publisher='" + userId + "' AND w.region='" + areaCode
					+ "' AND w.style='" + style + "' AND '" + constantInfo.getConstantCode()
					+ "'=w.family AND w.status='"+status+"' AND w.type='"+type+"' ORDER BY  publish_time DESC";
			List<SysWritingInfo> findList = sysWritingInfoMapper.findList(sql);
			// 查出状态不为2的 状态 1是发表 状态0是草稿 状态2不能显示表示已删除
			List<SysWritingInfo> list = new ArrayList<SysWritingInfo>();
			for (SysWritingInfo sysWritingInfo : findList) {
				if (sysWritingInfo.getStatus() != 2) {
					list.add(sysWritingInfo);
				}
			}
			// 转换成pageInfo对象
			PageInfo<SysWritingInfo> pageInfo = new PageInfo<>(list);
			CulturePage culturePage = new CulturePage();
			culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
			culturePage.setRows(pageInfo.getList());// 一页信息
			return ResponseUtlis.success(culturePage);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
		
	}

	/**
	 * 进入前台家族文化发表页面显示草稿信息
	 * 
	 * @param userId     用户ID
	 * @param column     栏目
	 * @param areaCode   地址ID
	 * @param familyName 姓氏名称
	 * @return
	 */
	@Override
	public Response<CulturePage> culturePublish(String userId, String column, String areaCode, String familyName,Integer pageNow, Integer pageSize,String type,Integer status) {
		try {
			// 查询出姓氏ID
			String sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
			SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
			// 开始分页
			PageHelper.startPage(pageNow, pageSize);
			// status状态1是发表 状态0是草稿2是不能发表已删除
			// 查询家族产业草稿
			sql = "SELECT w.* FROM sys_writing w WHERE w.region='" + areaCode + "' AND w.column='" + column + "' AND '"
					+ constantInfo.getConstantCode() + "'=w.family AND w.status='"+status+"' AND w.type='"+type+"' ORDER BY  publish_time DESC";
			List<SysWritingInfo> findList = sysWritingInfoMapper.findList(sql);
			// 转换成pageInfo对象
			PageInfo<SysWritingInfo> pageInfo = new PageInfo<>(findList);
			CulturePage culturePage = new CulturePage();
			culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
			culturePage.setRows(pageInfo.getList());// 一页信息
			return ResponseUtlis.success(culturePage);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
	}

	//前台草稿详情
	@Override
	public Response<SysWritingInfo> detailsPublish(String writingsId) {
		try {
			String sql = "SELECT w.* FROM sys_writing w WHERE w.writings_id='" + writingsId + "'";
			SysWritingInfo findOne = sysWritingInfoMapper.findOne(sql);
			return ResponseUtlis.success(findOne);
		} catch (Exception e) {
			
			
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
	}
	
	//前台家族文化发表页面草稿删除
	@Override
	public Response<SysWritingInfo> deletePublish(String writingsId) {
		try {
			String sql="DELETE FROM sys_writing WHERE writings_id = '" + writingsId + "'";
	     	sysWritingInfoMapper.delete(sql);
			return ResponseUtlis.error(SUCCESSFUL_CODE, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "删除失败");
		}
	}
	
	/**
	 * 前台发表 插入数据
	 * 
	 * @param title    标题
	 * @param text     内容
	 * @param style    分类
	 * @param areaName 上传输入地址名称
	 * @param path     图片地址
	 * @param status   状态
	 */

	@Override
	public Response<SysWritingInfo> publishData(String userId, String title, String text, Integer style,String synopsis, String familyName, String areaCode,String pic,
			Integer status,Integer type) {
		try {
			//将图片放入到FastDFS中生成地址
			/*FastDFSClient fastDFSClient = new FastDFSClient(ConstantClassField.SITE_FAST_DFS);
			String path = fastDFSClient.uploadFile(pic);
			path=ConstantClassField.IP_FAST_DFS+path;*/
			String path = StringUtils.getPath(pic);
			//生成ID
			String writingsId = String.valueOf(IDUtils.genId());
			//生成时间
			Timestamp format = DateUtil.format(new Date());
			/*// 查询地区编号
			String sql = "SELECT a.* FROM sys_area a WHERE a.area_leader=" + "'" + userId + "'";
			SysAreaInfo SysAreaInfo = sysAreaInfoMapper.findOne(sql);*/
			// 查询栏目
			String sql = "SELECT r.* FROM sys_rightinfo r WHERE r.right_id=" + "'" + style + "'";
			SysRightinfoInfo sysRightinfoInfo = sysRightinfoInfoMapper.findOne(sql);
			// 根据姓氏名称查出姓氏ID
			sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
			SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
			//插入数据
			 sql ="INSERT INTO `sys_writing` (`writings_id`, `region`, `title`, `summary`, `text`, `column`, `style`, `publisher`, `publish_time`, `focus`, `like`, `share`, `relay`, `reward`, `status`, `pic`, `family`, `collection`,`type`) VALUES ("
					+ "'"+writingsId+"',"
					+ "'"+areaCode+"',"
					+ "'"+title+"',"
					+ "'"+synopsis+"',"  //简介
					+ "'"+text+"',"
					+ "'"+sysRightinfoInfo.getParentId()+"',"
					+ "'"+style+"',"
					+ "'"+userId+"',"
					+ "'"+format+"',"
					+ "'"+0+"',"
					+ "'"+0+"',"
					+ "'"+0+"',"
					+ "'"+0+"',"
					+ "'"+0+"',"
					+ "'"+status+"',"
					+ "'"+path+"',"
					+ "'"+constantInfo.getConstantCode()+"',"
					+ "'"+0+"',"
					+ "'"+type+"')";
			sysWritingInfoMapper.insert(sql);
			return ResponseUtlis.error(SUCCESSFUL_CODE, "新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "新增失败");
		}
		
	}
	
	// 前台增加收藏数
	@Override
	public Response<SysWritingInfo> insertCollection(String writingsId,String userId) {
		try {
			//生成ID
			String collectId = String.valueOf(IDUtils.genId());
			//生成时间
			Timestamp format = DateUtil.format(new Date());
			// 查询出收藏数
			String sql = "SELECT w.collection FROM sys_writing w  WHERE w.writings_id='" + writingsId + "'";
			SysWritingInfo sysWritingInfo = sysWritingInfoMapper.findOne(sql);
			// 增加收藏数
			int collection = sysWritingInfo.getCollection() + 1;
			sql = " UPDATE sys_writing w  SET w.collection='" + collection + "' WHERE w.writings_id='" + writingsId + "'";
			sysWritingInfoMapper.update(sql);
			//将收藏的文章存入到收藏表
			sql="INSERT INTO sys_collect (`collect_id`,`user_id`,`writings_id`,`time`) VALUES ('"
			+collectId+"','"+userId+"','"+writingsId+"','"+format+"')";
			sysCollectInfoMapper.insert(sql);
			return ResponseUtlis.error(SUCCESSFUL_CODE, "收藏成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "收藏失败");
		}
	}

	// 前台增加点赞
	@Override
	public Response<SysWritingInfo> insertLike(String writingsId) {
		try {
			// 查询出点赞数
			String sql = "SELECT w.like FROM sys_writing w WHERE w.writings_id='" + writingsId + "';";
			SysWritingInfo findOne = sysWritingInfoMapper.findOne(sql);
			// 增加点赞数
			int like = findOne.getLike() + 1;
			sql = "UPDATE sys_writing w SET w.like='" + like + "' WHERE w.writings_id='" + writingsId + "'";
			sysAreaInfoMapper.update(sql);
			return ResponseUtlis.error(FAILURE_CODE, "点赞成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "点赞失败");
		}
		

	}

	// 前台查看详情增加查看数
	@Override
	public  Response<FamilyIndustry> selectParticulars(String writingsId) {
		try {
			// 查询出查看数 和详情
			String sql = "SELECT w.* FROM sys_writing w WHERE w.writings_id='" + writingsId + "'";
			FamilyIndustry findOne = familyIndustryMapper.findOne(sql);
			// 增加查看数
			int examine = findOne.getExamine() + 1;
			sql = "UPDATE sys_writing w SET w.examine='" + examine + "' WHERE w.writings_id='" + writingsId + "'";
			sysAreaInfoMapper.update(sql);
			// 查出详情
			/*
			 * sql =
			 * "SELECT w.*,a.`area_name`,u.`real_name` FROM sys_writing w,sys_area a,sys_user_reg u WHERE w.`writings_id`='"
			 * + writingsId +
			 * "' OR '"+findOne.getRegion()+"'=a.`area_code` OR '"+findOne.getPublisher()+
			 * "'=u.`user_id`";
			 */
			// 根据用户Id查出用户名
			sql = "SELECT u.* FROM sys_user_reg u WHERE u.user_id='" + findOne.getPublisher() + "'";
			SysUserRegInof userRegInof = sysUserRegInofMapper.findOne(sql);
			// 根据地区Id查出地区名
			sql = "SELECT a.* FROM sys_area a WHERE a.area_code='" + findOne.getRegion() + "'";
			SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);
			// 把用户名和地址名称放入到FamilyIndustry
			findOne.setConstantName(userRegInof.getRealName());
			findOne.setAreaName(sysAreaInfo.getAreaName());
			return ResponseUtlis.success(sysAreaInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
		

	}

	// 删除家族文化本县字派记录
	@Override
	public void deleteCulture(String zipaiId) {
		String sql = "DELETE FROM sys_zipai WHERE zipai_id = '" + zipaiId + "'";
		sysZipaiInfoMapper.delete(sql);
	}

	//  家族文化后台文章分类查询
	@Override
	public Response<SysRightinfoInfo> typeQuerying(Integer parentId) {
		try {
			String	sql = "SELECT r.* FROM sys_rightinfo r WHERE r.parent_id='" + parentId + "' ORDER BY right_id ASC";
			List<SysRightinfoInfo> findList = sysRightinfoInfoMapper.findList(sql);
			return ResponseUtlis.success(findList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
	}
	
	
	/**
	 * 家族文化后台文章分类添加
	 * 
	 * @param column    分类的栏目
	 * @param rightName
	 */
	// 状态1不能删除2可以删除
	@Override
	public Response<SysRightinfoInfo> addClassify(String column, String rightName) {
		try {
			String sql = "INSERT INTO sys_rightinfo (right_name, parent_id,status) VALUES ('" + rightName + "','" + column
					+ "','2')";
			sysRightinfoInfoMapper.insert(sql);
			return ResponseUtlis.error(FAILURE_CODE, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "添加失败");
		}
		
	}
	
	// 家族文化后台文章分类删除
	// 状态1不能删除2可以删除

	@Override
	public Response<SysRightinfoInfo> deleteClassify(int rightId) {
		try {
			// 查询出状态
			String sql = "SELECT r.* FROM sys_rightinfo r WHERE r.right_id='" + rightId + "'";
			SysRightinfoInfo rightinfoInfo = sysRightinfoInfoMapper.findOne(sql);
			// 判断状态
			if (rightinfoInfo.getStatus() == 2) {
				sql = "DELETE FROM sys_rightinfo WHERE right_id = '" + rightId + "';";
				sysRightinfoInfoMapper.delete(sql);
				return ResponseUtlis.error(SUCCESSFUL_CODE, "删除成功");
			}else {
				return ResponseUtlis.error(ERRO_CODE, "这个分类不能删除");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "删除失败");
		}
	}
	
	//*************************************************************************************************************************************
	//家族文化后台信息查询
	@Override
	public Response<CulturePage> backstageCommonality(String userId, Integer style, Integer pageNow, Integer pageSize,
			String areaCode, String familyName) {
		try {
			// 查询出姓氏ID
			String sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
			SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
			// 开始分页
			PageHelper.startPage(pageNow, pageSize);
			// status状态1是发表 状态0是草稿2是不能发表已删除
			sql = "SELECT w.*,a.area_name,u.real_name FROM sys_area a,sys_writing w,sys_user_reg u WHERE w.publisher='"
					+ userId + "' AND w.region='" + areaCode + "' AND w.style='" + style + "' AND '"
					+ constantInfo.getConstantCode() + "'=w.family AND w.publisher=u.user_id";
			List<FamilyIndustry> findList = familyIndustryMapper.findList(sql);
			List<FamilyIndustry> FamilyList=new ArrayList<FamilyIndustry>();
			 for (FamilyIndustry familyIndustry : findList) {
				if(familyIndustry.getStatus()!=2) {
					FamilyList.add(familyIndustry);
				}
			}
			// 转换成pageInfo对象
				PageInfo<FamilyIndustry> pageInfo = new PageInfo<>(FamilyList);
				CulturePage culturePage = new CulturePage();
				culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
				culturePage.setRows(pageInfo.getList());// 一页信息
			return ResponseUtlis.success(culturePage);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
		
	}
	//*************************************************************************************************************************************
	//家族文化后台查看详情
	@Override
	public Response<FamilyIndustry> backstage(String writingsId) {
		try {
			// 详情
			String sql = "SELECT w.* FROM sys_writing w WHERE w.writings_id='" + writingsId + "'";
			FamilyIndustry familyIndustry = familyIndustryMapper.findOne(sql);
			// 根据用户Id查出用户名
			sql = "SELECT u.* FROM sys_user_reg u WHERE u.user_id='" + familyIndustry.getPublisher() + "'";
			SysUserRegInof userRegInof = sysUserRegInofMapper.findOne(sql);
			// 根据地区Id查出地区名
			sql = "SELECT a.* FROM sys_area a WHERE a.area_code='" + familyIndustry.getRegion() + "'";
			SysAreaInfo sysAreaInfo = sysAreaInfoMapper.findOne(sql);
			// 把用户名和地址名称放入到FamilyIndustry
			familyIndustry.setConstantName(userRegInof.getRealName());
			familyIndustry.setAreaName(sysAreaInfo.getAreaName());
			return ResponseUtlis.success(familyIndustry);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "查询失败");
		}
		
	}

	// 家族文化后台进入修改页面
	@Override
	public Response<SysWritingInfo> amend(String writingsId) {
		try {
			String sql = "SELECT w.* FROM sys_writing w WHERE w.writings_id='" + writingsId + "'";
			SysWritingInfo writingInfo = sysWritingInfoMapper.findOne(sql);
			return ResponseUtlis.success(writingInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "修改失败");
		}
		
	}
    // 家族产业后台进入修改页面后发表或者草稿
	@Override
	public Response<SysWritingInfo> amendPublish(String writingsId, String title, String text, Integer style, String pic, Integer status,String synopsis) {
		try {
			//将图片放入到FastDFS中
			/*FastDFSClient fastDFSClient = new FastDFSClient(ConstantClassField.SITE_FAST_DFS);
			String path = fastDFSClient.uploadFile(pic);
			path=ConstantClassField.IP_FAST_DFS+path;*/
			String path = StringUtils.getPath(pic);
			//修改SysWritingInfo
			String  sql="update sys_writing set title='"+title+"',summary='"+synopsis+"',text='"+text+"',style='"+style+"',pic='"+path+"',status='"+status+"' WHERE writings_id='"+writingsId+"'";
			sysWritingInfoMapper.insert(sql);
			return ResponseUtlis.error(SUCCESSFUL_CODE, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "修改失败");
		}
		
	}
	
	//家族文化后台文章数据删除
	@Override
	public Response<SysWritingInfo> deleteData(String writingsId,Integer status) {
		try {
			//判断status状态为几           1是发表 状态0是草稿 状态2不能显示表示已删除
			String sql=null;
			if(status==1) {
				sql="UPDATE `sys_writing` SET `status`='2' WHERE (`writings_id`='"+writingsId+"')";
				sysWritingInfoMapper.update(sql);
			}else {
				sql="DELETE FROM sys_writing WHERE writings_id = '" + writingsId + "'";
				sysWritingInfoMapper.delete(sql);
			}
			return ResponseUtlis.error(SUCCESSFUL_CODE, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "删除失败");
		}
	}

	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&省级下属县级接口&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	
	//省级下属县级官网
	@Override
	public Response<SysConstantInfo> provincialUnderling(String areaCode, String familyName) {
		try {
			// 查询出姓氏ID
			String sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
			SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
			//查询出县级下属官网
			 sql="SELECT c.* FROM sys_area a,sys_constant c WHERE a.region='"+areaCode+"' AND a.surname='"+constantInfo.getConstantCode()+"' AND a.area_code=c.constant_code";
			List<SysConstantInfo> findList = sysConstantInfoMapper.findList(sql);
			return ResponseUtlis.success(findList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(FAILURE_CODE, "删除失败");
		}
	}
	
	
	
}


