package com.dct.swocean.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dct.swocean.common.ConstantClassField;
import com.dct.swocean.common.FastDFSClient;

public class StringUtils
{
    /**
     * 字符串为空
     * 
     * @param param
     * @return
     */
    public static boolean isEmpty(String param)
    {
        if (param == null || param.equals(""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 字符串不为空
     * 
     * @param param
     * @return
     */
    public static boolean isNotEmpty(String param)
    {
        if (isEmpty(param))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * 提取字符串中得数字
     * 
     * @param param
     * @return
     */
    public static String getNumber(String param)
    {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(param);
        return m.replaceAll("").trim();
    }
    
    /**
     * fastDFS图片地址获取全地址
     * @param pic  上传图片名称 
     * @return
     * @throws Exception 
     */
    public static String getPath(String pic) throws Exception {
    	FastDFSClient fastDFSClient = new FastDFSClient(ConstantClassField.SITE_FAST_DFS);
    	String path = fastDFSClient.uploadFile(pic);
    	return path = ConstantClassField.IP_FAST_DFS+path.substring(path.lastIndexOf("/")+1);
    }
}
