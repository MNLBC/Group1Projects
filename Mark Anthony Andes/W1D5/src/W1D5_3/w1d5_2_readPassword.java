package W1D5_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class w1d5_2_readPassword {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		System.out.print("Enter your Password: ");
		String input = scanner.next();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(input.getBytes());

		byte byteData[] = md.digest();

		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		System.out.println("Encrypted Password is : "+sb.toString());

		BufferedWriter br = new BufferedWriter(new FileWriter("digested-password.txt"));
		br.write(sb.toString());
		br.close();

		System.out.println("digested-password.txt created");
	}

}
