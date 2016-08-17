package com.intelligentCommunity.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密操作
 * 
 * @author feng
 *
 */
public final class PasswordUtil {

	/**
	 * 通过邮箱和密码得出加密后的密码
	 * 
	 * @param email 邮箱
	 * @param password 密码
	 * @return 加密后的密码
	 */
	public static String mixSaltPassword(String email,String password) {
		StringBuffer sb = new StringBuffer();
		sb.append(email);
		sb.append("feng");
		sb.append(password);
		return DigestUtils.md5Hex(sb.toString());
	}
	
	public static void main(String[] args) {
		System.err.println(mixSaltPassword("zhang@qq.com", "88888888"));
	}
	
}

