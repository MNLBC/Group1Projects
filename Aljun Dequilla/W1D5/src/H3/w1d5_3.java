package H3;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class w1d5_3 {

	/**
	 * @author DEQUIAL
	 * 
	 * This is main class for W1D5_3
	 * 
	 * @param args[] Main Parameters 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException  {
		// TODO Auto-generated method stub

		System.out.print("Enter password: ");
		Scanner scan = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(scan.next());
		scan.close();
		MessageDigest m = MessageDigest.getInstance("MD5");
		byte[] s = m.digest(sb.toString().getBytes());
		FileWriter wr = null;

		try {
			File f = new File("digested-password.txt");
			f.createNewFile();
			wr = new FileWriter(f);
			wr.append(s.toString());
		} finally {
			wr.flush();
			wr.close();
		}
	}

}
