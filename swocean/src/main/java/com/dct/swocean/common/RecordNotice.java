package com.dct.swocean.common;

import java.io.Serializable;

public class RecordNotice implements Serializable {

	/**
	 * 首页的家族记录动态
	 */
	private static final long serialVersionUID = 1L;
	private String writingsId;
	private String pic;
	private String areaName;
	private String summary;
	private String text;

	public String getWritingsId() {
		return writingsId;
	}

	public void setWritingsId(String writingsId) {
		this.writingsId = writingsId;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

}
