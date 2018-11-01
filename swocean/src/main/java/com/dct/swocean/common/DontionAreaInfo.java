package com.dct.swocean.common;

import java.io.Serializable;

//地区捐款人数
public class DontionAreaInfo implements Serializable {
    private String areaCode;
    private Long donorNum;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getDonorNum() {
        return donorNum;
    }

    public void setDonorNum(Long donorNum) {
        this.donorNum = donorNum;
    }
}
