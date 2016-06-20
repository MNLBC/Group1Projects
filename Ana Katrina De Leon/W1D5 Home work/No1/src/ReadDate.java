
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReadDate {

	public static void main(String[] args) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd EEE HH:mm:ss");
		SimpleDateFormat dayFormat = new SimpleDateFormat("E");
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		String currentDay = (String)dayFormat.format(currentDate).toString();  
		System.out.println("Today is " + currentDate);

		switch (EnumDays.valueOf(currentDay)) {
		case Mon:
			System.out.println("Take dogs to park");
			break;
		case Tue:
			System.out.println("Vist dentist");
			break;
		case Wed:
			System.out.println("Clean room");
			break;
		case Thu:
			System.out.println("Play volleyball");
			break;
		case Fri:
			System.out.println("Attend music festival");
			break;
		case Sat:
			System.out.println("Do household chores");
			break;
		case Sun:
			System.out.println("Go to church");
			break;
		default:
			throw new AssertionError("No appointment has been made");
		}


		

	}
}

