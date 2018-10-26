package com.dct.swocean.common;

import java.io.Serializable;

public class FamilyCelebrity implements Serializable{

	/**
	 * 首页家族名人
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String summary;
	private String text;
	private String rightName;
	private String pic;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	@Override
	public String toString() {
		return "FamilyCelebrity [userName=" + userName + ", summary=" + summary + ", text=" + text + ", rightName="
				+ rightName + ", pic=" + pic + "]";
	}
	
	
}
