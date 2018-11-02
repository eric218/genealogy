package com.dct.swocean.entity;

import java.util.Date;

public class SysPayOuts {
    private Integer id;

    private Integer netId;

    private Integer showPositionId;

    private Long payAmount;

    private String payContent;

    private String payChannel;

    private Date payTime;

    private String payUserid;

    private Long remain;

    private Integer status;

    private Date createTime;

    private Integer createUser;

    private Date updateTime;

    private Integer updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNetId() {
        return netId;
    }

    public void setNetId(Integer netId) {
        this.netId = netId;
    }

    public Integer getShowPositionId() {
        return showPositionId;
    }

    public void setShowPositionId(Integer showPositionId) {
        this.showPositionId = showPositionId;
    }

    public Long getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayContent() {
        return payContent;
    }

    public void setPayContent(String payContent) {
        this.payContent = payContent == null ? null : payContent.trim();
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel == null ? null : payChannel.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPayUserid() {
        return payUserid;
    }

    public void setPayUserid(String payUserid) {
        this.payUserid = payUserid == null ? null : payUserid.trim();
    }

    public Long getRemain() {
        return remain;
    }

    public void setRemain(Long remain) {
        this.remain = remain;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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