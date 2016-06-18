package w1_d5_3;

import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Scanner;

public class ReaderWriter {

	public static void main(String[] args) throws Exception {
		
		System.out.print("Enter password: ");
		Scanner input = new Scanner(System.in);
		String pw = input.nextLine();
				
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pw.getBytes());
        
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
		File f = new File("digested-password.txt");
		f.createNewFile();
		FileWriter writer = new FileWriter(f);
		
		writer.append(""+sb.toString());
		
		writer.flush();
		writer.close();
		
	}

}
