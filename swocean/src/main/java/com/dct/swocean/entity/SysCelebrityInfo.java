package com.dct.swocean.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysCelebrityInfo implements Serializable{

	/**
	 *家族名人组织结构后台
	 */
	private static final long serialVersionUID = 1L;
	private int celebrity_id;
	private int style;
	private String pic;
	private Timestamp celebrity_time;
	private String user_id;
	private String celebrity_name;
	private String summary;
	private String family;
	private String region;
	private int status;
	public int getCelebrity_id() {
		return celebrity_id;
	}
	public void setCelebrity_id(int celebrity_id) {
		this.celebrity_id = celebrity_id;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Timestamp getCelebrity_time() {
		return celebrity_time;
	}
	public void setCelebrity_time(Timestamp celebrity_time) {
		this.celebrity_time = celebrity_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCelebrity_name() {
		return celebrity_name;
	}
	public void setCelebrity_name(String celebrity_name) {
		this.celebrity_name = celebrity_name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
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
