import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionalHW {
	
	public boolean email(String e){
		String regex = "(@)|(.com)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(e);
		
		if(matcher.find()){
			return true;
		}
		return false;
	}
	
	public boolean number(String n){
		String regex = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(n);
		
		if(matcher.find()){
			return true;
		}
		return false;
	}
	
	public String character(String c){
		if(c.contains("a")){
			c = c.replace("a", "A");
		}
		return c;
	}
	
	public String dateTime(String dt){
		String dtSplit = dt.split(" ")[1];
		return dtSplit;

	}
}
