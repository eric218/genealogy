package com.dct.swocean.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SysATMs {
    private Integer drowId;

    private Integer netId;

    private BigDecimal drowAmount;

    private Date drowTime;

    private String drowName;

    private String drowInNum;

    private String drowInName;

    private String drowBank;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    public Integer getDrowId() {
        return drowId;
    }

    public void setDrowId(Integer drowId) {
        this.drowId = drowId;
    }

    public Integer getNetId() {
        return netId;
    }

    public void setNetId(Integer netId) {
        this.netId = netId;
    }

    public BigDecimal getDrowAmount() {
        return drowAmount;
    }

    public void setDrowAmount(BigDecimal drowAmount) {
        this.drowAmount = drowAmount;
    }

    public Date getDrowTime() {
        return drowTime;
    }

    public void setDrowTime(Date drowTime) {
        this.drowTime = drowTime;
    }

    public String getDrowName() {
        return drowName;
    }

    public void setDrowName(String drowName) {
        this.drowName = drowName == null ? null : drowName.trim();
    }

    public String getDrowInNum() {
        return drowInNum;
    }

    public void setDrowInNum(String drowInNum) {
        this.drowInNum = drowInNum == null ? null : drowInNum.trim();
    }

    public String getDrowInName() {
        return drowInName;
    }

    public void setDrowInName(String drowInName) {
        this.drowInName = drowInName == null ? null : drowInName.trim();
    }

    public String getDrowBank() {
        return drowBank;
    }

    public void setDrowBank(String drowBank) {
        this.drowBank = drowBank == null ? null : drowBank.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}