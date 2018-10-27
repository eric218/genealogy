package com.dc.swocean;

import org.junit.Test;



		public class GetImgSrc {
			//@Test
			// JUnit Test
			public static void main(String[] args){
			    String s = "xyzXYZ";
			    String b = "C:\\fakepath\\12.jpg";
			    System.out.println("base64编码的字符串值是 " + base64Encode(s));
			    System.out.println("base64解码字符串值是 " + base64Decode(base64Encode(s)));
			    System.out.println("base64编码的字符串值是 " + base64Encode(b));
			    System.out.println("base64解码字符串值是 " + base64Decode(base64Encode(b)));
			}
			// 编码
			public static String base64Encode(String token) {
			    byte[] encodedBytes = java.util.Base64.getEncoder().encode(token.getBytes());
			    return new String(encodedBytes,java.nio.charset.Charset.forName("UTF-8"));
			}
			// 解码
			public static String base64Decode(String token) {
			    byte[] decodedBytes = java.util.Base64.getDecoder().decode(token.getBytes());
			    return new String(decodedBytes, java.nio.charset.Charset.forName("UTF-8"));
			}
			}
