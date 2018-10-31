package com.dct.swocean.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.common.CulturePage;
import com.dct.swocean.common.IDUtils;
import com.dct.swocean.dao.SysCollectInfoMapper;
import com.dct.swocean.dao.SysCommentInfoMapper;
import com.dct.swocean.dao.SysConstantInfoMapper;
import com.dct.swocean.dao.SysFatherInfoMapper;
import com.dct.swocean.dao.SysZipaiInfoMapper;
import com.dct.swocean.entity.SysConstantInfo;
import com.dct.swocean.entity.SysFatherInfo;
import com.dct.swocean.entity.SysZipaiInfo;
import com.dct.swocean.entity.sysCommentInfo;
import com.dct.swocean.service.SysZiPaiService;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@SuppressWarnings("unchecked")
public class SysZiPaiServiceImpl implements SysZiPaiService {

	@Autowired
	private SysZipaiInfoMapper sysZipaiInfoMapper;
	@Autowired
	private SysConstantInfoMapper sysConstantInfoMapper;
	@Autowired
	private SysCollectInfoMapper sysCollectInfoMapper;
	@Autowired
	private SysCommentInfoMapper sysCommentInfoMapper;
	@Autowired
	private SysFatherInfoMapper sysFatherInfoMapper;

	//返回状态码 成功 200
	private Integer SUCCESSFUL_CODE=ConstantClassField.SUCCESSFUL_CODE;
	//返回状态码 失败 500
	private Integer FAILURE_CODE=ConstantClassField.FAILURE_CODE;
	//返回状态码 错误 400
	private Integer ERRO_CODE=ConstantClassField.ERRO_CODE;
	
	@Override
	public List<SysZipaiInfo> selectByFamilyName(String famliyname) {
		String sql = "select * from sys_zipai,sys_constant where constant_name=" + "'" + famliyname + "'";
		return sysZipaiInfoMapper.findList(sql);
	}

	@Override
	public SysZipaiInfo selectByUserId(String userId) {
		String sql = "select * from sys_zipai where creator = " + "'" + userId + "'";
		return sysZipaiInfoMapper.findOne(sql);
	}

	@Override
	public void updateByUserId(SysZipaiInfo sysZipaiInfo) {
		String sql = "update sys_zipai set zipai_order =" + "'" + sysZipaiInfo.getZipaiOrder() + "'"
				+ " where creator = " + "'" + sysZipaiInfo.getCreator() + "'";
		sysZipaiInfoMapper.update(sql);
	}
	
	
	//############################################# 家族文化栏目里的家族字派######################  
	
		// 家族字派信息查询
			@Override
			public Response<CulturePage> culture(String userId, Integer status, Integer pageNow, Integer pageSize, String areaCode,
					Integer family) {
			try {
				// 开始分页
				PageHelper.startPage(pageNow, pageSize);
				// 查询信息
				String sql = "SELECT z.* FROM sys_zipai z WHERE z.region='" + areaCode + "' AND z.surname='"
						+ family + "' AND z.status='" + status + "'";
				List<SysZipaiInfo> findList = sysZipaiInfoMapper.findList(sql);
				// 转换成pageInfo对象
				PageInfo<SysZipaiInfo> pageInfo = new PageInfo<>(findList);
				CulturePage culturePage = new CulturePage();
				culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
				culturePage.setRows(pageInfo.getList());// 一页信息
				return ResponseUtlis.success(culturePage);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseUtlis.error(FAILURE_CODE, "查询失败");
			}

			}

			//家族字派发表信息
			@Override
			public Response<SysZipaiInfo> publish(String userId, String location, String ancestorsName, String zipaiOrder, Integer family,
					String areaCode, String status) {
				try {
					//生成ID
					String zipaiId = String.valueOf(IDUtils.genId());
					//生成时间
					Timestamp format = DateUtil.format(new Date());
				    //储存数据
					String sql="INSERT INTO sys_zipai (`zipai_id`,`zipai_order`,`surname`,`region`,`ancestors_name`,`creator`,`create_time`,`status`,`like`,`comment`,`relay`,`collection`,`location`) VALUES ("
							+ "'"+zipaiId+"',"
							+ "'"+zipaiOrder+"',"
							+ "'"+family+"',"
							+ "'"+areaCode+"',"
							+ "'"+ancestorsName+"',"
							+ "'"+userId+"',"
							+ "'"+format+"',"
							+ "'"+status+"',"
							+ "'"+0+"',"
							+ "'"+0+"',"
							+ "'"+0+"',"
							+ "'"+0+"',"
							+ "'"+location+"')";
					sysZipaiInfoMapper.insert(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "发表成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "发表失败");
				}
			}

			//搜索
			@SuppressWarnings("unused")
			@Override
			public Response<CulturePage> search(String zipaiOrder,Integer pageNow, Integer pageSize) {
				try {
					// 开始分页
					PageHelper.startPage(pageNow, pageSize);
					String sql=null;
					if(zipaiOrder.equals("") && zipaiOrder==null) {
						return ResponseUtlis.error(ERRO_CODE, "不能为空");
					}else {
						sql="SELECT z.* FROM sys_zipai z WHERE zipai_order LIKE '%"+zipaiOrder+"%'";
					}
					List<SysZipaiInfo> list = sysZipaiInfoMapper.findList(sql);
					// 转换成pageInfo对象
					PageInfo<SysZipaiInfo> pageInfo = new PageInfo<>(list);
					CulturePage culturePage = new CulturePage();
					culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
					culturePage.setRows(pageInfo.getList());// 一页信息
					return ResponseUtlis.success(culturePage);
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "搜索失败");
				}
			}

			//家族字派发表页面详情
			@Override
			public Response<SysZipaiInfo> details(String zipaiId) {
				try {
					String sql="SELECT z.* FROM sys_zipai z WHERE zipai_id='"+zipaiId+"'";
					SysZipaiInfo sysZipaiInfo = sysZipaiInfoMapper.findOne(sql);
					return ResponseUtlis.success(sysZipaiInfo);
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "查询失败");
				}
			}

			//家族字派发表页面后删除
			@Override
			public Response<SysZipaiInfo> deletePublish(String zipaiId) {
				try {
					String sql="DELETE FROM sys_zipai WHERE zipai_id = '" + zipaiId + "'";
					sysZipaiInfoMapper.delete(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "删除成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "删除失败");
				}
			}

		// 家族字派后台页面信息查询
		@Override
		public Response<CulturePage> backstage(String userId, Integer pageNow, Integer pageSize, String areaCode,
				Integer family) {
			try {
				// 查询信息
				String sql = "SELECT z.* FROM sys_zipai z WHERE z.region='" + areaCode + "' AND z.surname='"
						+ family + "'";
				List<SysZipaiInfo> findList = sysZipaiInfoMapper.findList(sql);
				// 查出状态不为2的 状态1是发表 状态0是草稿 状态2不能显示表示已删除
				List<SysZipaiInfo> list = new ArrayList<SysZipaiInfo>();
				for (SysZipaiInfo sysZipaiInfo : findList) {
					if (sysZipaiInfo.getStatus() != 2) {
						list.add(sysZipaiInfo);
					}
				}
				// 转换成pageInfo对象
				PageInfo<SysZipaiInfo> pageInfo = new PageInfo<>(list);
				CulturePage culturePage = new CulturePage();
				culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
				culturePage.setRows(pageInfo.getList());// 一页信息
				return ResponseUtlis.success(culturePage);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseUtlis.error(FAILURE_CODE, "查询失败");
			}

		}

			// 家族字派后台信息的删除  状态status 1是发表 状态0是草稿 状态2不能显示表示已删除
			@Override
			public Response<SysZipaiInfo> removeDetails(String zipaiId, Integer status) {
				try {
					String sql=null;
					if(status==1) {
						sql="UPDATE `sys_zipai` SET `status`='2' WHERE (`zipai_id`='"+zipaiId+"')";
						sysZipaiInfoMapper.update(sql);
					}else {
						sql="DELETE FROM sys_zipai WHERE zipai_id = '" + zipaiId + "'";
						sysZipaiInfoMapper.delete(sql);
					}
					return ResponseUtlis.error(SUCCESSFUL_CODE, "删除成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "删除失败");
				}
			}

			//家族字派收藏
			@Override
			public Response<SysZipaiInfo> collect(String zipaiId, String userId) {
				try {
					//生成ID
					String collectId = String.valueOf(IDUtils.genId());
					//生成时间
					Timestamp format = DateUtil.format(new Date());
					// 查询出收藏数
					String sql = "SELECT z.collection FROM sys_zipai z WHERE z.zipai_id='" + zipaiId + "'";
					SysZipaiInfo findOne = sysZipaiInfoMapper.findOne(sql);
					// 增加收藏数
					int collection = findOne.getCollection() + 1;
					sql = " UPDATE sys_zipai z SET z.collection='" + collection + "' WHERE z.zipai_id='" + zipaiId + "'";
					sysZipaiInfoMapper.update(sql);
					//将收藏的文章存入到收藏表
					sql="INSERT INTO sys_collect (`collect_id`,`user_id`,`writings_id`,`time`) VALUES ('"
					+collectId+"','"+userId+"','"+zipaiId+"','"+format+"')";
					sysCollectInfoMapper.insert(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "收藏成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "收藏失败");
				}
			}

			//家族字派点赞 
			@Override
			public Response<SysZipaiInfo> insertLike(String zipaiId) {
				try {
					// 查询出点赞数
					String sql = "SELECT z.collection FROM sys_zipai z WHERE z.zipai_id='" + zipaiId + "'";
					SysZipaiInfo findOne = sysZipaiInfoMapper.findOne(sql);
					//增加点赞数
					int like = findOne.getLike() + 1;
					sql = " UPDATE sys_zipai z SET z.like='" + like + "' WHERE z.zipai_id='" + zipaiId + "'";
					sysZipaiInfoMapper.update(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "点赞成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "点赞失败");
				}
			}

			//家族字派转发
			@Override
			public Response<SysZipaiInfo> insertRelay(String zipaiId) {
				try {
					// 查询出转发数
					String sql = "SELECT z.collection FROM sys_zipai z WHERE z.zipai_id='" + zipaiId + "'";
					SysZipaiInfo findOne = sysZipaiInfoMapper.findOne(sql);
					//增加转发数
					int relay = findOne.getRelay() + 1;
					sql = " UPDATE sys_zipai z SET z.relay='" + relay + "' WHERE z.zipai_id='" + zipaiId + "'";
					sysZipaiInfoMapper.update(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "转发成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "转发失败");
				}
			}

			//进入家族字派父评论页面
				@Override
				public Response<sysCommentInfo> selectComment(String zipaiId) {
					try {
						String sql="SELECT c.* FROM sys_comment c WHERE c.writings_id='" + zipaiId + "'";
						List<sysCommentInfo> findList = sysCommentInfoMapper.findList(sql);
						return ResponseUtlis.success(findList);
					} catch (Exception e) {
						e.printStackTrace();
						return ResponseUtlis.error(FAILURE_CODE, "进入评论失败");
					}
				}

			// 家族字派子评论显示
			@Override
			public Response<SysFatherInfo> selectFather(String fatherId) {
				try {
					String sql="SELECT f.* FROM sys_father f WHERE f.fatherId='" + fatherId + "'";
					List<SysFatherInfo> findList = sysFatherInfoMapper.findList(sql);
					return ResponseUtlis.success(findList);
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "显示失败");
				}
			}
				
			//家族字派父评论
			@Override
			public Response<sysCommentInfo> comment(String zipaiId,String text,String userId) {
				try {
					//生成ID
					String commentId = String.valueOf(IDUtils.genId());
					//生成时间
					Timestamp format = DateUtil.format(new Date());
					// 生成fatherIdID fatherId子评论ID关联
					String fatherId = String.valueOf(IDUtils.genId());
					// 评论表内容存入 
					String sql="INSERT INTO sys_comment (`comment_id`,`text`,`user_id`,`time`,`writings_id`,`fatherId`) VALUES ("
							+ "'"+commentId+"',"
							+ "'"+text+"'," 
							+ "'"+userId+"'," 
							+ "'"+format+"'," 
							+ "'"+zipaiId+"',"
							+ "'"+fatherId+"')";
					sysCommentInfoMapper.insert(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "评论成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "评论失败");
				}
			}

			//家族字派子评论
			@Override
			public Response<SysFatherInfo> father(String text, String fatherId) {
				try {
					//生成时间
					Timestamp format = DateUtil.format(new Date());
					// 评论表内容存入 
					String sql="INSERT INTO sys_father (`fatherId`,`time`,`text`) VALUES ("
							+ "'"+fatherId+"'," 
							+ "'"+format+"',"
							+ "'"+text+"')";
					sysFatherInfoMapper.insert(sql);
					return ResponseUtlis.error(SUCCESSFUL_CODE, "评论成功");
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "评论失败");
				}
			}

			//**************************省级页面******************************
			
			//省级地区选择下拉框
			@Override
			public Response<SysConstantInfo> county(String areaCode, String family) {
				try {
					String sql="SELECT " + 
							"c.* " + 
							"FROM " + 
							"sys_area AS a ," + 
							"sys_constant AS c " + 
							"WHERE " + 
							"a.region = '"+areaCode+"' AND " + 
							"a.surname = '"+family+"' AND " + 
							"a.area_code = c.constant_code";
					List<SysConstantInfo> findList = sysConstantInfoMapper.findList(sql);
					return ResponseUtlis.success(findList);
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "查询失败");
				}
			}

			//省级地区选择下拉框地区字派查询
			@Override
			public Response<CulturePage> selectCounty(String areaCode, String family, Integer status, Integer pageNow, Integer pageSize) {
				try {
					// 开始分页
					PageHelper.startPage(pageNow, pageSize);
					String sql="SELECT " + 
							"z.* " + 
							"FROM " + 
							"sys_zipai AS z " + 
							"WHERE " + 
							"z.region = '"+areaCode+"' AND " + 
							"z.surname = '"+family+"' AND " + 
							"z.`status` = '"+status+"' " + 
							"ORDER BY " + 
							"z.create_time DESC";
					List<SysZipaiInfo> findList = sysZipaiInfoMapper.findList(sql);
					// 转换成pageInfo对象
					PageInfo<SysZipaiInfo> pageInfo = new PageInfo<>(findList);
					CulturePage culturePage = new CulturePage();
					culturePage.setTotal(pageInfo.getTotal());// 总的信息条数
					culturePage.setRows(pageInfo.getList());// 一页信息
					return ResponseUtlis.success(culturePage);
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseUtlis.error(FAILURE_CODE, "查询失败");
				}
			}

}
