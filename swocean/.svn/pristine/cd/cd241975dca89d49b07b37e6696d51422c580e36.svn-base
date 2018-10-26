package com.dct.swocean.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@ControllerAdvice
public class ExceptionHandle
{

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handle(Exception e)
    {
        if (e instanceof SysException)
        {
            SysException sysException = (SysException) e;
            return ResponseUtlis.error(sysException.getCode(), sysException.getMessage());
        }
        else
        {
            logger.error(ResponseEnum.UNKNOW_ERROR.getMsg(), e);
            return ResponseUtlis.error(ResponseEnum.UNKNOW_ERROR.getCode(), ResponseEnum.UNKNOW_ERROR.getMsg());
        }
    }
    
    /**
     * 获取异常的堆栈信息
     * 
     * @param t
     * @return
     */
    public static String printStackTraceToString(Throwable t)
    {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
    
    /**
     * 错误日志处理结果
     * @param e
     * @param url
     * @param json
     * @return
     */
    public static String getExceptionJson(Throwable e,String url,String json){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("stack", printStackTraceToString(e));
        map.put("message", e.getMessage());
        map.put("url", url);
        @SuppressWarnings("unchecked")
        Map<String,Object> jsonMap = (Map<String, Object>) JSON.parse(json);
        map.putAll(jsonMap);;
        return JSON.toJSONString(map);
        
    } 

}
