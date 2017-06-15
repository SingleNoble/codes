package com.cmfz.until;

import java.util.Random;
/**
 * 随机盐的工具类
 * @author Administrator
 *
 */
public class SaltUtil {
	
	/**
	 * 生成随机盐的方法
	 * @param n
	 * @return
	 */
	public static String  getSalt(int n){
		char[] code ="1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%&".toCharArray();
		//随机数
		Random random = new Random();
		//StringBuilder 线程不安全  轻量级    效率高
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(code[random.nextInt(code.length)]);
		}
		return sb.toString();
	}
}
