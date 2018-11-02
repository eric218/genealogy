package com.dct.swocean.entity;

import java.util.Date;

public class SysFamilySummarys {
    private Integer id;

    private Integer netId;

    private Integer showPositionId;

    private String rootGroup;

    private String rootPerson;

    private Integer netLeader;

    private String netPhone;

    private Integer worshipNum;

    private Integer praiseNum;

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

    public String getRootGroup() {
        return rootGroup;
    }

    public void setRootGroup(String rootGroup) {
        this.rootGroup = rootGroup == null ? null : rootGroup.trim();
    }

    public String getRootPerson() {
        return rootPerson;
    }

    public void setRootPerson(String rootPerson) {
        this.rootPerson = rootPerson == null ? null : rootPerson.trim();
    }

    public Integer getNetLeader() {
        return netLeader;
    }

    public void setNetLeader(Integer netLeader) {
        this.netLeader = netLeader;
    }

    public String getNetPhone() {
        return netPhone;
    }

    public void setNetPhone(String netPhone) {
        this.netPhone = netPhone == null ? null : netPhone.trim();
    }

    public Integer getWorshipNum() {
        return worshipNum;
    }

    public void setWorshipNum(Integer worshipNum) {
        this.worshipNum = worshipNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
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