package W1D5_1;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;



public class w1d5_1_dateReader {
	

	public static void main(String[] args) {
		displayDateAndTodo();
	}

	private static void displayDateAndTodo() {
		Date today = Calendar.getInstance().getTime();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd EEE hh:mm:ss");
		 String dateToday = sdf.format(today);
		 String day = dateToday.split(" ")[1].toUpperCase();
		 System.out.println("Today is: "+dateToday);
		 
		 

		 switch (day) {
		case "MON":
			System.out.println("Go to Work");
			break;
		case "TUE":
			System.out.println("Go to Work");
			break;
		case "WED":
			System.out.println("Go to Work");
			break;
		case "THU":
			System.out.println("Go to Church");
			break;
		case "FRI":
			System.out.println("NETFLIX and Chill");
			break;
		case "SAT":
			System.out.println("no appointment has been made");
			break;
		case "SUN":
			System.out.println("Family Time");
			break;

		default:
			break;
		}
		
	}

}
