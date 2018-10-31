package com.dct.swocean.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class SysAccountInfo implements Serializable {

	private String accountId;
	private String account;
	private String name;
	private String descript;
	private Integer type;
	private BigDecimal remain;
	private Integer status;
	private String region;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public BigDecimal getRemain() {
		return remain;
	}

	public void setRemain(BigDecimal remain) {
		this.remain = remain;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
