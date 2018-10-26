package com.dct.swocean.entity;

import java.util.Date;

public class LogSystem
{
    private int id;
    private int systemId;
    private String addby;
    private Date addTime;
    private String type;
    private String tableCode;
    private String tableName;
    private String loginId;
    private String description;
    private String remark;
    private String objectId;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getSystemId()
    {
        return systemId;
    }
    public void setSystemId(int systemId)
    {
        this.systemId = systemId;
    }
    public String getAddby()
    {
        return addby;
    }
    public void setAddby(String addby)
    {
        this.addby = addby;
    }
    public Date getAddTime()
    {
        return addTime;
    }
    public void setAddTime(Date addTime)
    {
        this.addTime = addTime;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getTableCode()
    {
        return tableCode;
    }
    public void setTableCode(String tableCode)
    {
        this.tableCode = tableCode;
    }
    public String getTableName()
    {
        return tableName;
    }
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }
    public String getLoginId()
    {
        return loginId;
    }
    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    public String getObjectId()
    {
        return objectId;
    }
    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }
    
    

}
