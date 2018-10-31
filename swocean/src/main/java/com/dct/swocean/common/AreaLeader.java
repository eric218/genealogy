package com.dct.swocean.common;

import java.io.Serializable;

//地区管理员数量
public class AreaLeader implements Serializable {

    private String areaCode;
    private String familyName;
    private Long count;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
