package com.dct.swocean.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class SysFatherInfo implements Serializable{

	/**
	 * 子评论表
	 */
	private static final long serialVersionUID = 1L;
	private int seed_id;
	private String fatherId;
	private Timestamp time;
	private String text;
	public int getSeed_id() {
		return seed_id;
	}
	public void setSeed_id(int seed_id) {
		this.seed_id = seed_id;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
}
