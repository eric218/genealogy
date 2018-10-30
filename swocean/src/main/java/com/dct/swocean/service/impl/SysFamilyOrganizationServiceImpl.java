package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.FamilyIndustry;
import com.dct.swocean.common.FamilyOrganization;
import com.dct.swocean.common.FastDFSClient;
import com.dct.swocean.dao.FamilyOrganizationMapper;
import com.dct.swocean.dao.SysCelebrityInfoMapper;
import com.dct.swocean.dao.SysConstantInfoMapper;
import com.dct.swocean.dao.SysRightinfoInfoMapper;
import com.dct.swocean.entity.SysCelebrityInfo;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysRightinfoInfo;
import com.dct.swocean.service.SysFamilyOrganizationService;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@SuppressWarnings("unchecked")
public class SysFamilyOrganizationServiceImpl implements SysFamilyOrganizationService {

	@Autowired
	private SysRightinfoInfoMapper sysRightinfoInfoMapper;
	@Autowired
	private SysConstantInfoMapper sysConstantInfoMapper;
	@Autowired
	private SysCelebrityInfoMapper sysCelebrityInfoMapper;
	@Autowired
	private FamilyOrganizationMapper familyOrganizationMapper;
	
	//家族组织机构后台文章分类查询
	@Override
	public Response<SysRightinfoInfo> typeQuerying(Integer parentId) {
		try {
			String	sql = "SELECT r.* FROM sys_rightinfo r WHERE r.parent_id='" + parentId + "' ORDER BY right_id ASC";
			List<SysRightinfoInfo> findList = sysRightinfoInfoMapper.findList(sql);
			return ResponseUtlis.success(findList);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	}
	
	
	//家族组织机构后台文章分类添加
	@Override
	public Response<SysRightinfoInfo> addClassify(String column, String rightName,Integer status) {
		try {
			String sql = "INSERT INTO sys_rightinfo (right_name, parent_id,status) VALUES ('" + rightName + "','" + column
					+ "','"+status+"')";
			sysRightinfoInfoMapper.insert(sql);
			return ResponseUtlis.error(200, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "添加失败");
		}
		
	}
   
	//家族组织机构后台文章分类删除
	@Override
	public Response<SysRightinfoInfo> deleteClassify(String rightId) {
		try {
			// 查询出状态
			String sql = "SELECT r.* FROM sys_rightinfo r WHERE r.right_id='" + rightId + "'";
			SysRightinfoInfo rightinfoInfo = sysRightinfoInfoMapper.findOne(sql);
			// 判断状态 状态1可以删除2不可以删除
			if (rightinfoInfo.getStatus() == 2) {
				sql = "DELETE FROM sys_rightinfo WHERE right_id = '" + rightId + "';";
				sysRightinfoInfoMapper.delete(sql);
				return ResponseUtlis.error(200, "删除成功");
			}else {
				return ResponseUtlis.error(401, "这个分类不能删除");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "删除失败");
		}
	}

	//家族组织机构添加人物
	@Override
	public Response<SysCelebrityInfo> addFigure(String userId, Integer style, String celebrityName, String synopsis, String familyName,
			String areaCode, String pic, Integer status) {
		try {
			// 将图片放入到FastDFS中
			FastDFSClient fastDFSClient = new FastDFSClient(ConstantClassField.SITE_FAST_DFS);
			String path = fastDFSClient.uploadFile(pic);
			path = ConstantClassField.IP_FAST_DFS + path;
			// 查询出姓氏ID
			String sql = "SELECT c.* FROM sys_constant c WHERE constant_name='" + familyName + "'";
			SysConstantInfo constantInfo = sysConstantInfoMapper.findOne(sql);
			// 生成时间
			Timestamp format = DateUtil.format(new Date());
			// 新增
			sql = "INSERT INTO sys_celebrity (`style`,`pic`,`celebrity_time`,`user_id`,`celebrity_name`,`summary`,`family`,`region`,`status`) VALUES ('" 
			+ style + "','"+pic+"','"+ format + "','" + userId + "','"+celebrityName+"','" + synopsis + "','" + constantInfo.getConstantCode() + "',"
					+ "'"+areaCode+"','"+status+"')";
			sysCelebrityInfoMapper.insert(sql);
			return ResponseUtlis.error(200, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "添加失败");
		}

	}

	//家族组织机构查看详情
	@Override
	public Response<SysCelebrityInfo> backstage(String celebrityId) {
		try {
			// 详情
			String sql = "SELECT c.* FROM sys_celebrity c WHERE c.celebrity_id='" + celebrityId + "'";
			SysCelebrityInfo findOne = sysCelebrityInfoMapper.findOne(sql);
			return ResponseUtlis.success(findOne);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
		
	}

	//家族组织机构删除信息
	@Override
	public Response<SysCelebrityInfo> deletePublish(String celebrityId) {
		try {
			// 删除 修改状态 转态1发表2已删除
			String sql="UPDATE `sys_celebrity` SET `status`='2' WHERE (`celebrity_id`='"+celebrityId+"')";
			sysCelebrityInfoMapper.update(sql);
			return ResponseUtlis.error(200, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "删除失败");
		}
	}

	@Override
	public Response<CulturePage> culture(Integer style, Integer pageNow, Integer pageSize, String areaCode, String familyName,
			Integer status) {
		try {
			// 开始分页
			PageHelper.startPage(pageNow, pageSize);
			String sql="SELECT c.*,r.right_name FROM sys_celebrity c,sys_rightinfo r , sys_constant t WHERE r.right_id='"+style+"'AND t.constant_name='" + familyName + "' AND c.region='" + areaCode
					+ "' AND c.family=t.constant_code AND c.`status`='" + status + "'";
			List<FamilyOrganization> findList = familyOrganizationMapper.findList(sql);
			// 转换成pageInfo对象
			PageInfo<FamilyOrganization> pageInfo = new PageInfo<>(findList);
			CulturePage culturePage = new CulturePage();
			culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
			culturePage.setRows(pageInfo.getList());// 一页信息
			return ResponseUtlis.success(culturePage);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtlis.error(500, "查询失败");
		}
	
	}

	
}
