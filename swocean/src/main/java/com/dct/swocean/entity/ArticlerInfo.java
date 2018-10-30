package com.dct.swocean.entity;

import java.io.Serializable;

public class ArticlerInfo implements Serializable {

    private String userId;
    private String region;
    private String pic;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

}
