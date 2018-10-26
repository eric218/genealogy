package com.dct.swocean.util;

public class SysException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    private Integer code;

    public SysException(ResponseEnum responseEnum)
    {
        super(responseEnum.getMsg());
        this.code = responseEnum.getCode();
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }
}
