package w1d5.number3;

import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Scanner;

public class ReadWrite {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter password to be secured: ");
		String inputText = input.next();

		MessageDigest msgDigest = MessageDigest.getInstance("MD5");
		msgDigest.update(inputText.getBytes());

		byte byteStorage[] = msgDigest.digest();

		StringBuffer strngBffr = new StringBuffer();
		for (int i = 0; i < byteStorage.length; i++) {
			strngBffr.append(Integer.toString((byteStorage[i] & 0xff) + 0x100, 16).substring(1));
		}
		File generatedFile = new File("digested-password.txt");
		generatedFile.createNewFile();
		FileWriter writer = new FileWriter(generatedFile);

		writer.append("" + strngBffr.toString());

		writer.flush();
		writer.close();

	}

}
