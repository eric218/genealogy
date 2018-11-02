package com.dct.swocean.entitys;

import java.util.Date;

public class SysZiPai {
    private Integer id;

    private Integer netId;

    private Integer showPositionId;

    private String zipaiOrder;

    private String ancestorsName;

    private Integer praiseNum;

    private Integer commentNum;

    private Integer relayNum;

    private Integer collectionNum;

    private String ziapiLocation;

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

    public String getZipaiOrder() {
        return zipaiOrder;
    }

    public void setZipaiOrder(String zipaiOrder) {
        this.zipaiOrder = zipaiOrder == null ? null : zipaiOrder.trim();
    }

    public String getAncestorsName() {
        return ancestorsName;
    }

    public void setAncestorsName(String ancestorsName) {
        this.ancestorsName = ancestorsName == null ? null : ancestorsName.trim();
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getRelayNum() {
        return relayNum;
    }

    public void setRelayNum(Integer relayNum) {
        this.relayNum = relayNum;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public String getZiapiLocation() {
        return ziapiLocation;
    }

    public void setZiapiLocation(String ziapiLocation) {
        this.ziapiLocation = ziapiLocation == null ? null : ziapiLocation.trim();
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