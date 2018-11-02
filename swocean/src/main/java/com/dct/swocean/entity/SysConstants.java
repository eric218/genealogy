package com.dct.swocean.entity;

public class SysConstants {
    private String constantGroup;

    private String constantName;

    private String constantCode;

    private String comment;

    public String getConstantGroup() {
        return constantGroup;
    }

    public void setConstantGroup(String constantGroup) {
        this.constantGroup = constantGroup == null ? null : constantGroup.trim();
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName == null ? null : constantName.trim();
    }

    public String getConstantCode() {
        return constantCode;
    }

    public void setConstantCode(String constantCode) {
        this.constantCode = constantCode == null ? null : constantCode.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}