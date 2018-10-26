package com.dct.swocean.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dct.swocean.dao.SysUserInfoMapper;
import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.service.SysUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@CacheConfig(cacheNames = "userCache")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserInfoService{

	@Autowired
    private SysUserInfoMapper userMapper;


	// 因为必须要有返回值，才能保存到数据库中，如果保存的对象的某些字段是需要数据库生成的，
	//那保存对象进数据库的时候，就没必要放到缓存了
	
	
	@Cacheable(key="'user'+#id") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
	public SysUserInfo findById(Integer id){
		String sql = "select u.* from sys_userinfo u where u.userid=" + id;
		SysUserInfo user = userMapper.findOne(sql);
		return user;
	}
	
	
	
	//@Cacheable(key="#p0") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
	public SysUserInfo findByLoginName(String loginname){
		String sql = "select u.* from sys_userinfo u where u.loginname=" + loginname;
		SysUserInfo user = userMapper.findOne(sql);
		return user;
	}

	//@Cacheable(key="#p0") // @Cacheable 会先查询缓存，如果缓存中存在，则不执行方法
	public List<SysUserInfo> findAll(){
		String sql = "select u.* from sys_userinfo u ";
		List<SysUserInfo> userList = new ArrayList<SysUserInfo>();
		userList = userMapper.findList(sql);
		return userList;
	}
	
	public List<SysUserInfo> findByPage(Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		String sql = "select u.* from sys_userinfo u ";
		List<SysUserInfo> userList = userMapper.findList(sql);
		PageInfo<SysUserInfo> pageInfo = new PageInfo<SysUserInfo>(userList);
	    //System.out.println(pageInfo.getTotal() + "  " + pageInfo.isIsFirstPage() + "  " + pageInfo.isIsLastPage() + pageInfo.getSize());
		return pageInfo.getList();
	}

	@CacheEvict(key="#id.toString()")  //删除缓存名称为userCache,key等于指定的id对应的缓存
	public void deleteById(Integer id){
		String sql = "delete from sys_userinfo where userid=" + id;
		userMapper.delete(sql);
	}
		

	//清空缓存名称为userCache（看类名上的注解)下的所有缓存
	//如果数据失败了，缓存时不会清除的
	@CacheEvict(allEntries = true)
	public void deleteAll(){
		String sql = "";
		userMapper.delete(sql);
	}

}
