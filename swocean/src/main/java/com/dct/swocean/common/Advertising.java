package com.dct.swocean.common;

import java.io.Serializable;

/**
 * 
 * 家族文化和家长产业上大广告的数据和大广告地址
 *
 */

public class Advertising implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String areaName;    //家族地址
	private String constantName;  //姓氏
	private String pinyin;        //家族地址拼音 
	private String file_path;     //图片地址
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	
}
