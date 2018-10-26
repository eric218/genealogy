package com.dct.swocean.controller;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.entity.SysRoleInfo;
import com.dct.swocean.service.SysRoleInfoService;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.ExceptionHandle;
import com.dct.swocean.util.ImageRemarkUtil;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/role")
@SuppressWarnings("unchecked")
public class SysRoleInfoController
{
    private final static Logger logger = LoggerFactory.getLogger(SysRoleInfoController.class);
    @Autowired
    private SysRoleInfoService service;

    // @RequestMapping("/add")
    // public Response<SysRoleInfo> add(@RequestBody SysRoleInfo sysRoleInfo)
    // {
    // service.add(sysRoleInfo);
    // return ResponseUtlis.success();
    // }
    //
    // @RequestMapping("/delete/{roleid}")
    // public Response<SysRoleInfo> delete(@PathVariable("roleid") int roleid)
    // {
    // return ResponseUtlis.success();
    // }
    //
    // @RequestMapping("/update")
    // public Response<SysRoleInfo> update(@RequestBody SysRoleInfo sysRoleInfo)
    // {
    // service.update(sysRoleInfo);
    // return ResponseUtlis.success();
    // }

//    @RequestMapping("/findOne/{json}")
//    public Response<SysRoleInfo> findOne(HttpServletRequest request,@PathVariable("json")String json)
//    {
//    	JSONObject jsonObj = JSONObject.parseObject(json);
//    	Integer roleid = jsonObj.getInteger("roleid");
//        Map<String, Object> map = new HashMap<String, Object>();
//        map = service.findOne(roleid);
//        return ResponseUtlis.success(map);
//    }
//
//    @RequestMapping("/findAll")
//    public Response<SysRoleInfo> findAll()
//    {
//        List<SysRoleInfo> list = new ArrayList<SysRoleInfo>();
//        String sql = "select roleid,rolename,rolecode from sys_roleinfo";
//        list = service.findAll(sql);
//        return ResponseUtlis.success(list);
//    }
//    
//    @RequestMapping("/findByPage/{json}")
//    public Response<SysRoleInfo> findByPage(HttpServletRequest request,@PathVariable("json")String json)
//    {
//    	JSONObject jsonObj = JSONObject.parseObject(json);
//    	PageHelper.startPage(jsonObj.getInteger("pageNum"), jsonObj.getInteger("pageSize"));
//        List<SysRoleInfo> list = new ArrayList<SysRoleInfo>();
//        String sql = "select roleid,rolename,rolecode from sys_roleinfo";
//        list = service.findAll(sql);
//        PageInfo<SysRoleInfo> pageInfo = new PageInfo<SysRoleInfo>(list);
//	    System.out.println(pageInfo.getTotal() + "  " + pageInfo.isIsFirstPage() + "  " + pageInfo.isIsLastPage() + pageInfo.getSize());
//        return ResponseUtlis.success(pageInfo.getList());
//    }
//
//    @RequestMapping("/call/{json}")
//    public Response<SysRoleInfo> call(HttpServletRequest request,@PathVariable("json")String json)
//    {
//    	JSONObject jsonObj = JSONObject.parseObject(json);
//    	Integer id = jsonObj.getInteger("id");
//        String sql = "call find_rolename_by_id("+id+")";
//        SysRoleInfo sysRoleInfo = (SysRoleInfo) service.call(sql);
//        return ResponseUtlis.success(sysRoleInfo);
//    }

    // @RequestMapping("/findByRolename")
    // public Response<SysRoleInfo> findByRolename()
    // {
    // SysRoleInfo sysRoleInfo = service.selectByRolename("系统管理员2");
    // return ResponseUtlis.success(sysRoleInfo);
    // }
}
