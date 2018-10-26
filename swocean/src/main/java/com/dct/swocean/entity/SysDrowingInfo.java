package com.dct.swocean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SysDrowingInfo implements Serializable {

	private String drowId;
	private BigDecimal drowAmount;
	private Timestamp drowTime;
	private String drowName;
	private String drowOutNum;
	private String drowInNum;
	private String drowInName;
	private String drowBank;

	public String getDrowId() {
		return drowId;
	}

	public void setDrowId(String drowId) {
		this.drowId = drowId;
	}

	public BigDecimal getDrowAmount() {
		return drowAmount;
	}

	public void setDrowAmount(BigDecimal drowAmount) {
		this.drowAmount = drowAmount;
	}

	public Timestamp getDrowTime() {
		return drowTime;
	}

	public void setDrowTime(Timestamp drowTime) {
		this.drowTime = drowTime;
	}

	public String getDrowName() {
		return drowName;
	}

	public void setDrowName(String drowName) {
		this.drowName = drowName;
	}

	public String getDrowOutNum() {
		return drowOutNum;
	}

	public void setDrowOutNum(String drowOutNum) {
		this.drowOutNum = drowOutNum;
	}

	public String getDrowInNum() {
		return drowInNum;
	}

	public void setDrowInNum(String drowInNum) {
		this.drowInNum = drowInNum;
	}

	public String getDrowInName() {
		return drowInName;
	}

	public void setDrowInName(String drowInName) {
		this.drowInName = drowInName;
	}

	public String getDrowBank() {
		return drowBank;
	}

	public void setDrowBank(String drowBank) {
		this.drowBank = drowBank;
	}

}
