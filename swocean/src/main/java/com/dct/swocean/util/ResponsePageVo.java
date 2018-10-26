package com.dct.swocean.util;

import java.util.List;

/**
 * 分页data
 * 
 * @author panda
 *
 * @param <T>
 */
public class ResponsePageVo<T>
{
    private List<T> list;

    private int size;

    private int number;

    private long totalCount;

    private int totalPage;

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }
}
