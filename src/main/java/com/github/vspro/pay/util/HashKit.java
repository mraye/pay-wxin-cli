package com.github.vspro.pay.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class HashKit {

	private static final char[] LETTERS = "0123456789ABCDEF".toCharArray();

	/**
	 * MD5加密
	 */
	public static String md5(String value) {
		try {
			return hash(MessageDigest.getInstance("MD5"), value);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * SHA1 加密
	 */
	public static String sha1(String value) {
		try {
			return hash(MessageDigest.getInstance("SHA1"), value);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String hash(MessageDigest digest, String src) {
		try {
			return toHexString(digest.digest(src.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}

	/**
	 * 将字节转换为十六进制字符串 
	 * @param bytes
	 * @return
	 */
	private static String toHexString(byte[] bytes) {
		char[] values = new char[bytes.length * 2];
		int i = 0;
		for (byte b : bytes) {
			values[i++] = LETTERS[((b & 0xF0) >>> 4)];
			values[i++] = LETTERS[b & 0xF];
		}
		return String.valueOf(values);
	}



}