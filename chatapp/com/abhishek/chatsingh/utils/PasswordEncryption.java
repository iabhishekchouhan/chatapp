package com.abhishek.chatsingh.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface PasswordEncryption {
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException{
		String encryptedPassword=null;
		MessageDigest md=MessageDigest.getInstance("MD5");
		md.update(plainPassword.getBytes());
		byte []encrypt =md.digest();
//		encryptedPassword = new String(encrypt);
		
		StringBuffer sb=new StringBuffer();
		for(byte b:encrypt) {
			sb.append(b);
		}
		encryptedPassword=sb.toString();
//		System.out.println("Encrypted Password : "+ sb.toString());
		return encryptedPassword;
	}
//	public static void main(String[] args) throws NoSuchAlgorithmException {
//		System.out.println(passwordEncrypt("abhishek"));
//	}
}
