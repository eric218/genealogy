package com.dct.swocean.util.dbhelper;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.dct.swocean.util.StringUtils;

public class UpdateSQL extends RequestSQL
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
        String sql = "UPDATE " + super.getTable() + " SET ";
        Iterator<Entry<String, Object>> it = column.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Object> entry = it.next();
            if (it.hasNext())
            {
                sql = sql + entry.getKey() + "=" + entry.getValue() + ", ";
            }
            else
            {
                sql = sql + entry.getKey() + "=" + entry.getValue() + " ";
            }
        }
        if (StringUtils.isNotEmpty(super.getCondition()))
        {
            sql = sql + super.getCondition();
        }
        return sql;
    }

}
