package com.dct.swocean.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class SysPayLogInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 支付流水ID
	private String payId;

	// 支付账号
	private String payCount;

	// 支付金额
	private BigDecimal payAmount;

	// 所属地区
	private String region;

	// 支出內容
	private String payContent;

	// 支付渠道
	private String payChannel;

	// 支付时间
	private Timestamp payTime;

	// 支付人
	private String payUserId;

	// 余额
	private BigDecimal remain;

	// 创建人
	private String creator;

	// 创建时间
	private Timestamp createTime;

	// 状态
	private Integer status;

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayCount() {
		return payCount;
	}

	public void setPayCount(String payCount) {
		this.payCount = payCount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPayContent() {
		return payContent;
	}

	public void setPayContent(String payContent) {
		this.payContent = payContent;
	}

	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	public Timestamp getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public String getPayUserId() {
		return payUserId;
	}

	public void setPayUserId(String payUserId) {
		this.payUserId = payUserId;
	}

	public BigDecimal getRemain() {
		return remain;
	}

	public void setRemain(BigDecimal remain) {
		this.remain = remain;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
