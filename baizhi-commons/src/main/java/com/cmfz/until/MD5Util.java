package com.cmfz.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 * Md5工具方法的封装
 * @author Administrator
 *
 */
public class MD5Util{

	/**
	 * 用来生成md5加密结果
	 * @param password  加密内容
	 * @return
	 */
	public static String getMd5Code(String password){
		try {
			//java.secutiry
			MessageDigest messageDigest = MessageDigest.getInstance("md5") ;
			//加密 将密码 转为 元素个数为16 的byte数组
			byte[] digest = messageDigest.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			//byte转为16进制长度是32位字符串 
			for (byte b : digest) {    
				int c = b & 0xff;
				if(c<16){
					sb.append("0");
				}
				sb.append(Integer.toHexString(c));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
