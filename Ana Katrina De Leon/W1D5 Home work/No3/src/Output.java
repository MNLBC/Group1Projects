import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Output {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter credit card account: ");
		String name = scanner.nextLine();
		
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(String.valueOf(sb).getBytes());
		byte[] encrypted = md.digest();
		
		System.out.println(encrypted);
		
		File file = new File("D:\\digested-password.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		
		writer.append(""+encrypted);
		
		writer.flush();
		writer.close();
	}

}
