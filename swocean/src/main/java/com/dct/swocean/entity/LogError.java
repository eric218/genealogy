package com.dct.swocean.entity;

import java.util.Date;

public class LogError
{
    private int id;
    private String stack;
    private String message;
    private String page;
    private String method;
    private String curUseId;
    private Date addTime;
    private String isReport;
    private String remark;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getStack()
    {
        return stack;
    }
    public void setStack(String stack)
    {
        this.stack = stack;
    }
    public String getMessage()
    {
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    public String getPage()
    {
        return page;
    }
    public void setPage(String page)
    {
        this.page = page;
    }
    public String getMethod()
    {
        return method;
    }
    public void setMethod(String method)
    {
        this.method = method;
    }
    public String getCurUseId()
    {
        return curUseId;
    }
    public void setCurUseId(String curUseId)
    {
        this.curUseId = curUseId;
    }
    public Date getAddTime()
    {
        return addTime;
    }
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }
    public String getIsReport()
    {
        return isReport;
    }
    public void setIsReport(String isReport)
    {
        this.isReport = isReport;
    }
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    
    

}
