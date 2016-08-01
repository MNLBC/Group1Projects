package w1d3_3;

import java.util.regex.*;

public class w1d3_3 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		boolean a = validEmail("abc123@oocl.com");
//		String s = replaceA("abakada");
//		String as = getMonth("Tue Jun 14 21:30:31 CST 2016");
//
//	}

	public static boolean validEmail(String s) {
		String regex = "[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,}";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);

		return m.matches();
	}

	public static boolean validNumCP(String s) {
		String regex = "^09[0-9]{9}$";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);

		return m.matches();
	}

	public static String replaceA(String s) {
//		String regex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
//
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(s);
		
		return s.replaceAll("a", "A");
	}

	public static String getMonth(String s) {
//		String regex = "[A-z]{3}\\s";
//
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(s);
//		
////		Tue Jun 14 21:30:31 CST 2016
		
		return s.split("\\s")[1].toString().trim();
	}

}
