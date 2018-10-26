package com.dct.swocean.util.dbhelper;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.dct.swocean.util.StringUtils;

public class InsertSQL extends RequestSQL
{
    private Map<String, Object> column;

    public Map<String, Object> getColumn()
    {
        return column;
    }

    public void setColumn(Map<String, Object> column)
    {
        this.column = column;
    }

    @Override
    public String produceSQL()
    {
        if (StringUtils.isEmpty(super.getTable()) || this.column == null || this.column.size() == 0)
        {
            return null;
        }
        String sql = "INSERT INTO ";
        String columnName = "";
        String columnValue = "";
        Iterator<Entry<String, Object>> it = column.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Object> entry = it.next();
            if (it.hasNext())
            {
                columnName = columnName + entry.getKey() + ", ";
                columnValue = columnValue + entry.getValue() + ", ";
            }
            else
            {
                columnName = columnName + entry.getKey() + " ";
                columnValue = columnValue + entry.getValue() + " ";
            }
        }
        sql = sql + super.getTable() + " (" + columnName + ")" + " VALUES (" + columnValue + ")";
        return sql;
    }

}
