package com.dct.swocean.common;

import java.io.Serializable;

import com.dct.swocean.entity.SysAreaInfo;
import com.dct.swocean.entity.SysWritingInfo;

/**
 * 
    *显示家族产业和家族产业所用的实体类****不是首页的
 */
public class FamilyIndustry extends SysWritingInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String constantName; //真实姓名
	private String areaName; //地址名称
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
}
