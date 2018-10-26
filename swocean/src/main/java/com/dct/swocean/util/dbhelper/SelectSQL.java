package com.dct.swocean.util.dbhelper;

import com.dct.swocean.util.StringUtils;

public class SelectSQL extends RequestSQL
{
    private String resultType;// 查询方式：count,findOne,findList
    
    private String[] column;// 查询字段数组

    public String getResultType()
    {
        return resultType;
    }

    public void setResultType(String resultType)
    {
        this.resultType = resultType;
    }

    public String[] getColumn()
    {
        return column;
    }

    public void setColumn(String[] column)
    {
        this.column = column;
    }

    @Override
    public String produceSQL()
    {
        if (StringUtils.isEmpty(super.getTable()) || this.column == null || this.column.length == 0)
        {
            return null;
        }
        String sql = "SELECT";
        for (int i = 0; i < column.length; i++)
        {
            if (i == column.length - 1)
            {
                sql = sql + " " + column[i] + " ";
            }
            else
            {
                sql = sql + " " + column[i] + ", ";
            }
        }
        if (StringUtils.isEmpty(super.getCondition()))
        {
            sql = sql + "FROM " + super.getTable();
        }
        else
        {
            sql = sql + "FROM " + super.getTable() + " " + super.getCondition();
        }
        return sql;
    }
}
