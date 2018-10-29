package com.dct.swocean.common;

import java.io.Serializable;

import com.dct.swocean.entity.SysCelebrityInfo;

//家族组织结构后台显示分页显示数据
public class FamilyOrganization extends SysCelebrityInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rightName;

	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	
	
}
