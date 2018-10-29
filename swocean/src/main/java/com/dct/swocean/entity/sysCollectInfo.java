package com.dct.swocean.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class sysCollectInfo implements Serializable{

	/**
	 * 收藏文章表
	 */
	private static final long serialVersionUID = 1L;
	private String collectId;
	private String userId;
	private String writingsId;
	private Timestamp time;
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWritingsId() {
		return writingsId;
	}
	public void setWritingsId(String writingsId) {
		this.writingsId = writingsId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	

}
