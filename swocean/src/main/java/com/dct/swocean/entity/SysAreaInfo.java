package com.dct.swocean.entity;

import java.io.Serializable;

public class SysAreaInfo implements Serializable{

	/**
	 * 地址实体类
	 */
	private static final long serialVersionUID = 1L;
	private int areaId;
	private String areaName;
	private String surname;
	private String areaCode;
	private String areaLeader;
	private int areaType;
	private String region;
	private int status;
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaLeader() {
		return areaLeader;
	}
	public void setAreaLeader(String areaLeader) {
		this.areaLeader = areaLeader;
	}
	public int getAreaType() {
		return areaType;
	}
	public void setAreaType(int areaType) {
		this.areaType = areaType;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
