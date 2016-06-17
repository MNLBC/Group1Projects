package com.oocl.mnlbc.num3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * 
 * @author barrepe
 *
 */

public class App {
	
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner in  = new Scanner(System.in);
		System.out.print("Input Password: ");
		
		StringBuffer stBuff = new StringBuffer(in.nextLine());
		
		String converted = convertToMD5(stBuff);
		System.out.println(converted);
		
		PrintWriter writer = new PrintWriter("digested-password.txt", "UTF-8");
		writer.println(converted);
		writer.close();
		
		
	}
	
	public static String convertToMD5(StringBuffer input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String inputStr = input.toString();
            byte[] messageDigest = md.digest(inputStr.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
