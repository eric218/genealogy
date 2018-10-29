package com.dct.swocean.entity;

import java.io.Serializable;

public class SysDescInfo implements Serializable {

    private String descId;
    private String descGroup;
    private String descRoot;
    private String areaCode;
    private String descLeader;
    private String phone;
    private Integer worship;
    private Integer zan;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescId() {
        return descId;
    }

    public void setDescId(String descId) {
        this.descId = descId;
    }

    public String getDescGroup() {
        return descGroup;
    }

    public void setDescGroup(String descGroup) {
        this.descGroup = descGroup;
    }

    public String getDescRoot() {
        return descRoot;
    }

    public void setDescRoot(String descRoot) {
        this.descRoot = descRoot;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getDescLeader() {
        return descLeader;
    }

    public void setDescLeader(String descLeader) {
        this.descLeader = descLeader;
    }

    public Integer getWorship() {
        return worship;
    }

    public void setWorship(Integer worship) {
        this.worship = worship;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }
}
