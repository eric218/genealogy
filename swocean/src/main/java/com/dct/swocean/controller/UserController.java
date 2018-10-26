package com.dct.swocean.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.util.DateUtil;
import com.dct.swocean.util.ExceptionHandle;

import io.swagger.annotations.Api;

@Api(tags = "操作用户的api")
@Controller
@RequestMapping("/user")
public class UserController
{
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 
     * @return
     * @throws Exception
     */
    @RequestMapping("/test")
    @ResponseBody
    public String login(HttpServletRequest request, String json)
    {
        try
        {
            throw new Exception("异常");
        }
        catch (Exception e)
        {
            logger.error(ExceptionHandle.getExceptionJson(e, request.getRequestURI(),json), ConstantClassField.ERROR_LOG,
                    "用户名", DateUtil.getTime());
        }
        return "test";
    }
}
