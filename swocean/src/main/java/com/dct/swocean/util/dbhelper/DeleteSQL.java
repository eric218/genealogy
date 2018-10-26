package com.dct.swocean.util.dbhelper;

import com.dct.swocean.util.StringUtils;

public class DeleteSQL extends RequestSQL
{
    @Override
    public String produceSQL()
    {
        if (StringUtils.isEmpty(super.getTable()))
        {
            return null;
        }
        String sql = "DELETE FROM " + super.getTable();
        if (StringUtils.isNotEmpty(super.getCondition()))
        {
            sql = sql + super.getTable() + " " + super.getCondition();
        }
        return sql;
    }

}
