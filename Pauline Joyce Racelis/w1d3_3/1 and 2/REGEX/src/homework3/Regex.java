package homework3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {
	
	public static boolean email(String email){
		String regex = "[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,}";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		return m.matches();

		
	}
	public static boolean mobile(String mobile){
		
		String regex = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		return m.matches();

		
	}
	
	

}
