package com.pair.nkweb.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class SecurityAES256 {

	@Value("${se.key}")
	private String key;
	@Value("${se.iv}")
	private String iv;
	
	byte[] secret;
	byte[] IV;
	
	
	@PostConstruct
	public void init() {
		
		secret = hexStringToByteArray(key);
		IV = hexStringToByteArray(iv);
	}
	
	public String AES_Decode_tel(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
		
		if(str.length()<2)
			return str;
		int a = str.lastIndexOf("-");
		String first = str.substring(a + 1);
		str = str.substring(0, a + 1);
		SecretKey secretKey = new SecretKeySpec(secret, "AES");
		
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		c.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(IV));
		
		byte[] byteStr = Base64.getDecoder().decode(first.replace("-", "+").getBytes());
		
		String result = new String(c.doFinal(byteStr), "euc-kr");
		
		byte[] utf8 = result.getBytes(StandardCharsets.UTF_8);
		
		String utf8Result = new String(utf8, StandardCharsets.UTF_8);
		
		return str + utf8Result;
	
	}
	
	
	public String AES_Decode_addr(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
		
		SecretKey secretKey = new SecretKeySpec(secret, "AES");
		
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		c.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(IV));
		
		int a = str.lastIndexOf(" ");
		String second_result = str.substring(a + 1);
		str = str.substring(0, a + 1);
		
		byte[] byteStr = Base64.getDecoder().decode(second_result.getBytes());
		
		String result = new String(c.doFinal(byteStr), "euc-kr");
		
		byte[] utf8 = result.getBytes(StandardCharsets.UTF_8);
		String utf8Result = new String(utf8, StandardCharsets.UTF_8);
		
		
		return str + utf8Result;
		
	}
	
	
	private byte[] hexStringToByteArray(String s) {
		
		int len = s.length();
		
		byte[] data = new byte[len / 2];
		
		for(int i=0 ; i<len ; i+=2) {
			data[i/2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1),  16));
			
		}
		
		return data;
	}
}
