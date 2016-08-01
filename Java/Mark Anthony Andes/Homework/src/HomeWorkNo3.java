import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWorkNo3 {

	
	public boolean email(String email) {
		
		
			 String regex = "(@yahoo)|(@gmail)|(@rockmail)|(@outlook)|(@li)|(.com)|(.ph)|(.net)|(.org)";   
			 Pattern p = Pattern.compile(regex); 
			
				 Matcher m = p.matcher(email); 
				 if(m.find())
					 return true;
				 
				return false;
			}
	
	

	public boolean mobileNumber(String email) {
		
		
			 String regex = "^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";   
			 Pattern p = Pattern.compile(regex); 
				 Matcher m = p.matcher(email); 
				 if(m.find())
					 return true;
			
			return false ;
	}
	
	
	public String text(String text) {
		
		text = text.replace("a", "A");
		System.out.println(text);
		return text;
		}
	
	
	public String dateText(String dateText) {
		dateText = dateText.split(" ")[1];
		System.out.println(dateText);
		return dateText ;
		}
	
	
	
}
