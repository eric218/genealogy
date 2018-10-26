package com.dct.swocean.util.stringhelper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isBlank(String str) {
		if (str == null || str.isEmpty())
			return true;
		return false;

	}

	public static boolean isNotRealIp(String ip){
		if(ip ==null || ip.length() ==0 || "unknown".equalsIgnoreCase(ip))
			return true;
		else
			return false;
	}

	public static boolean isBlankUp(String str) {
		if (str == null || str.isEmpty() || "null".equals(str.toLowerCase()))
			return true;
		return false;

	}

	public static String changeNUlltoEmpty(String str){
		if(isBlankUp(str)){
			return "";
		}else{
			return str;
		}
	}

	public static String trim(String str) {
		if (str == null || str.isEmpty())
			return "";

		return str.trim();

	}

	/**
	 * 检测并修正分隔字符串
	 *
	 * @param string
	 * @param regex  分割符(可以为长字符串)
	 * @return
	 */
	public static String checkSplitString(String string, String regex) {
		String[] ids = string.split(regex);
		List<String> list = new ArrayList<String>();
		for (String id : ids) {
			if (id.trim().length() > 0) {
				list.add(id);
			}
		}
		string = "";
		for (String id : list) {
			string += id + ",";
		}
		if (string.endsWith(",")) string = string.substring(0, string.length() - 1);
		return string;
	}

	/**
	 * 分割字符串 返回integer型数据
	 *
	 * @param string
	 * @param regex  分割符(可以为长字符串)
	 * @return
	 */
	public static Integer[] splitToIntegerArray(String string, String regex) {
		String[] ids = string.split(regex);
		Integer[] array = new Integer[ids.length];
		int i = 0;
		for (String id : ids) {
			if (id.trim().length() > 0) {
				array[i++] = Integer.parseInt(id.trim());
			}
		}
		return array;
	}

	/**
	 * ,分割字符串 返回integer型数据
	 *
	 * @param string
	 * @return
	 */
	public static Integer[] splitToIntegerArray(String string) {
		return splitToIntegerArray(string, ",");
	}

	/**
	 * 分割字符串 返回long型数据
	 *
	 * @param string
	 * @param regex  分割符(可以为长字符串)
	 * @return
	 */
	public static Long[] splitToLongArray(String string, String regex) {
		String[] ids = string.split(regex);
		Long[] array = new Long[ids.length];
		int i = 0;
		for (String id : ids) {
			if (id.trim().length() > 0) {
				array[i++] = Long.parseLong(id.trim());
			}
		}
		return array;
	}

	/**
	 * ,分割字符串 返回long型数据
	 *
	 * @param string
	 * @return
	 */
	public static Long[] splitToLongArray(String string) {
		return splitToLongArray(string, ",");
	}

	/**
	 * ISOToUTF8
	 *
	 * @param s
	 * @return
	 */
	public static String ISOToUTF8(String s) {
		try {
			return new String(s.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	/**
	 * ISOToUTF8
	 *
	 * @param s
	 * @return
	 */
	public static String UTF8ToISO(String s) {
		try {
			return new String(s.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	/**
	 * URLEncoderToUTF8
	 *
	 * @param s
	 * @return
	 */
	public static String URLEncoderToUTF8(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	public static String URLDecoderToUTF8(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	/**
	 * 将首字母转换为大写
	 *
	 * @param string
	 * @return
	 */
	public static String convertFirstCharToUpperCase(String string) {
		if (string != null && string.length() > 1) {
			return Character.toUpperCase(string.charAt(0)) + string.substring(1);
		}
		return string;
	}

	/**
	 * 将首字母转换为小写
	 *
	 * @param string
	 * @return
	 */
	public static String convertFirstCharToLowerCase(String string) {
		if (string != null && string.length() > 1) {
			return Character.toLowerCase(string.charAt(0)) + string.substring(1);
		}
		return string;
	}

	/**
	 * 如果string 以exp开头或以exp结尾则截去
	 *
	 * @param string
	 * @param exp
	 * @return
	 */
	public static String trim(String string, String exp) {
		while (string.startsWith(exp)) {
			string = string.replaceFirst(exp, "");
		}
		while (string.endsWith(exp)) {
			string = string.substring(0, string.lastIndexOf(exp));
		}
		return string;
	}

	public static Double stringToDouble(String str) {
		if (isBlank(str)) {
			return null;
		}
		Double d = -1.0;
		try {
			d = Double.parseDouble(str);
			return d;
		} catch (Exception ex) {
			return null;
		}

	}

	public static String float2Str(float f) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String p = decimalFormat.format(f);//
		return p;
	}

	public static String  GenerateGUID(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	public static String listToString(List<String> stringList,String symbol){
		if (stringList==null) {
			return null;
		}
		if(symbol == null )
			symbol = ",";
		StringBuilder result=new StringBuilder();
		boolean flag=false;
		for (String string : stringList) {
			if (flag) {
				result.append(symbol);
			}else {
				flag=true;
			}
			result.append(string);
		}
		return result.toString();
	}
	public static String delHTMLTag(String htmlStr){
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
		String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
		String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

		Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
		Matcher m_script=p_script.matcher(htmlStr);
		htmlStr=m_script.replaceAll(""); //过滤script标签

		Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
		Matcher m_style=p_style.matcher(htmlStr);
		htmlStr=m_style.replaceAll(""); //过滤style标签

		Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
		Matcher m_html=p_html.matcher(htmlStr);
		htmlStr=m_html.replaceAll(""); //过滤html标签

		return htmlStr.trim(); //返回文本字符串
	}

	public static boolean isTeacherEmail(String email){
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+edu\\.cn$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(email);
		boolean isMatched = matcher.matches();
		return isMatched;
	}
	public static boolean isGoodPwd(String pwd){
		String check = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(pwd);
		boolean isMatched = matcher.matches();
		return isMatched;
	}

	public static String trimRN(String str){
		if(!isBlank(str)){
			return str.replace("\n","").replace("\r","");
		}
		return str;
	}

	public static String trimStartEndRN(String str){
		if(!isBlank(str)){
			str = trim(str," ");
			str = trim(str,"\r\n");
			str = trim(str,"\r");
			str = trim(str,"\n");
			str = trim(str," ");
			str = trim(str,"\t");
		}
		return str;
	}

	public static boolean isInteger(String str){
		if(isBlank(str))
			return  false;
		try{
			int i = Integer.valueOf(str);
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

	public static List<Integer> stringToAscii(String value)
	{
		List<Integer> list = new ArrayList<>();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			list.add((int)chars[i]);
		}
		return list;
	}
}
