package com.dct.swocean.entity;

import java.io.Serializable;

public class UserVideoInfo implements Serializable {

    private String areaCode;
    private Long videoCount;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(Long videoCount) {
        this.videoCount = videoCount;
    }
}
