
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class W1D3_no3 {
	
	static Pattern p;
	static Matcher m;
	
	public static boolean mailValidate(String x){
		p = Pattern.compile("[A-z0-9._%+-]+@[A-z0-9.-]+\\.[A-z]{2,}");
		m = p.matcher(x);
		return m.find();
	}
	
	public static boolean phoneValidate(String x){
		p = Pattern.compile("^09[0-9]{9}$");
		m = p.matcher(x);
		return m.find();
	}
	
	public static String replaceA(String x){
		return x.replace('a', 'A');
	}
	
	public static String getMonth(String x){
		
		return x.split(" ")[1];
	}
	

}
