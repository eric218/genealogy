package com.dct.swocean.entity;

import java.io.Serializable;

public class SysConstantInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int constantId;
	private int constantType;
	private String constantName;
	private String constantCode;
	private String belongs;
	private int status;
	private String backup;
	public int getConstantId() {
		return constantId;
	}
	public void setConstantId(int constantId) {
		this.constantId = constantId;
	}
	public int getConstantType() {
		return constantType;
	}
	public void setConstantType(int constantType) {
		this.constantType = constantType;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public String getConstantCode() {
		return constantCode;
	}
	public void setConstantCode(String constantCode) {
		this.constantCode = constantCode;
	}
	public String getBelongs() {
		return belongs;
	}
	public void setBelongs(String belongs) {
		this.belongs = belongs;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBackup() {
		return backup;
	}
	public void setBackup(String backup) {
		this.backup = backup;
	}
	
	
}
