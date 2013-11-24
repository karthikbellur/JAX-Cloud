package com.action;

/* This class is responsible for encryption of password */

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public class CryptoUtils {

	//encrypts the given input string into a 28-character hash  
	public synchronized static String encrypt(String plaintext) throws Exception
	  {
	    MessageDigest md = null;
	    md = MessageDigest.getInstance("SHA");	//Returns a MessageDigest object that implements the specified digest algorithm
	    md.update(plaintext.getBytes("UTF-8")); 	//Update the digest using the specified ByteBuffer
	    byte raw[] = md.digest(); 	//Completes the hash computation by performing final operations such as padding
	    String hash = (new BASE64Encoder()).encode(raw); 
	    return hash; 
	  }
}
