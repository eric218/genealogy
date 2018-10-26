package com.dct.swocean.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dct.swocean.entity.SysRoleInfo;
import com.dct.swocean.entity.SysUserInfo;
import com.dct.swocean.service.SysUserInfoService;
import com.dct.swocean.util.Response;
import com.dct.swocean.util.ResponseUtlis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@Api(value="这是用户控制器",tags={"操作用户的api"})
@RestController
@RequestMapping("/user")
@SuppressWarnings("unchecked")
public class SysUserInfoController
{
    @Autowired
    private SysUserInfoService userService;


    @ApiOperation(value="查找用户", notes="",response=Map.class)
    @RequestMapping(value = "/findOne/{json}",method = RequestMethod.GET)
    public Response<SysUserInfo> findOne(HttpServletRequest request,@ApiParam("userid")@PathVariable("json")String json)
    {
    	JSONObject jsonObj = JSONObject.parseObject(json);
     	Integer userid = jsonObj.getInteger("userid");
        SysUserInfo user = userService.findById(userid);
        return ResponseUtlis.success(user);
    }
    
   
    @ApiOperation(value="删除用户",notes="",httpMethod ="GET",response=Map.class)
    @RequestMapping(value = "/delOne/{json}",method = RequestMethod.GET)
    //@ApiImplicitParam(name = "userid", value = "需要删除的用户id",dataType="int",paramType = "query", required = true)
    public Response<SysUserInfo> delOne(HttpServletRequest request,@PathVariable("json")String json)
    {
    	JSONObject jsonObj = JSONObject.parseObject(json);
     	Integer userid = jsonObj.getInteger("userid");
        userService.deleteById(userid);
        return ResponseUtlis.success("删除成功");
    }


    @ApiOperation(value="查找所有用户", notes="",httpMethod ="GET",response=Map.class)
    @RequestMapping(value = "/findAll/{json}",method = RequestMethod.GET)
    public Response<SysRoleInfo> findAll(HttpServletRequest request,@PathVariable("json")String json)
    {
        List<SysUserInfo> list = new ArrayList<SysUserInfo>();
        
        list = userService.findAll();
        return ResponseUtlis.success(list);
    }
    

    @ApiOperation(value="分页查找用户", notes="",httpMethod ="GET",response=Map.class)
    @RequestMapping(value = "/findByPage/{json}",method = RequestMethod.GET)
    public Response<SysRoleInfo> findByPage(HttpServletRequest request,@PathVariable("json")String json)
    {
    	JSONObject jsonObject = JSON.parseObject(json);
    	Integer pageNum = jsonObject.getInteger("pageNum");
    	Integer pageSize = jsonObject.getInteger("pageSize");
        return ResponseUtlis.success(userService.findByPage(pageNum, pageSize));
    }

    
   
}
