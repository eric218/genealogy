package com.dct.swocean.entity;

import java.io.Serializable;

public class DescInfo implements Serializable {

    private String areaCode;
    private Long count;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
