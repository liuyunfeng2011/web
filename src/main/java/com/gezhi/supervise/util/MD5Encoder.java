package com.gezhi.supervise.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;
/**
 * 
 * @author Liuyf
 *用户用户密码MD5处理，主要encode加密  isPasswordValid验证新输入和已存在的密码
 */
@Component("passwordEncoder")
public class MD5Encoder {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	private String salt;
	private String algorithm = "MD5";// 默认加密方式采取MD5

	public MD5Encoder() {
	}

	/**
	 * @param mySalt用户需要使用的盐
	 * @param rawPass用户输入的字符密码
	 * @return 加密+盐的密码操作
	 */
	public String encode(String mySalt,String rawPass) {
		this.salt=mySalt;
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes("utf-8")));
		} catch (Exception ex) {
		}
		return result;
	}

	/**
	 * @param useSalt 用户使用的盐
	 * @param encPass 已经加密过的字符
	 * @param rawPass 新输入字符
	 * @return
	 */
	public boolean isPasswordValid(String useSalt,String encPass, String rawPass) {
		String pass1 = "" + encPass;
		String pass2 = encode(useSalt,rawPass);

		return pass1.equals(pass2);
	}

	private String mergePasswordAndSalt(String password) {
		if (password == null) {
			password = "";
		}

		if ((salt == null) || "".equals(salt)) {
			return password;
		} else {
			return password + "{" + salt.toString() + "}";
		}
	}

	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
}
