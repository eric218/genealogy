package com.dct.swocean.common;

import java.io.Serializable;

import com.dct.swocean.entity.SysDonationInfo;

public class Donation extends SysDonationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 二维码生成类
	private String codeUrl;

	// 标题
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

}
