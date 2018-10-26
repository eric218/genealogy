package com.dct.swocean.util.dbhelper;

public abstract class RequestSQL
{
    private int primaryKey;// 主键：redis缓存使用
    
    private String table;// 操作表

    private String condition;// sql语句条件：WHERE ...

    public int getPrimaryKey()
    {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey)
    {
        this.primaryKey = primaryKey;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }

    public String getCondition()
    {
        return condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }

    public abstract String produceSQL();// 生产sql的方法
}
