package com.dct.swocean.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class sysCommentInfo implements Serializable{

	/**
	 * 父评论表
	 */
	private static final long serialVersionUID = 1L;
	private String commentId;
	private String text;
	private String userId;
	private Timestamp time;
	private String writingsId;
	private String fatherId;
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getWritingsId() {
		return writingsId;
	}
	public void setWritingsId(String writingsId) {
		this.writingsId = writingsId;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	
}
