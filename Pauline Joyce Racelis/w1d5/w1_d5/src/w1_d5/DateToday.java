package w1_d5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToday {

	public static void main(String[] args) {
		String day;
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd EEE HH:mm:ss");
		SimpleDateFormat dateDay = new SimpleDateFormat("EEE");
		System.out.println("Date and time today: " + dateFormat.format(date)); // 2013/10/15
																				// 16:16:39

		day = dateDay.format(date);
		switch (day) {
		case "Mon":
			System.out.println(Days.Mon.toString());
			break;
		case "Tue":
			System.out.println(Days.Tue.toString());
			break;
		case "Wed":
			System.out.println(Days.Wed.toString());
			break;
		case "Thu":
			System.out.println(Days.Thu.toString());
			break;
		case "Fri":
			System.out.println(Days.Fri.toString());
			break;
		case "Sat":
			System.out.println(Days.Sat.toString());
			break;
		case "Sun":
			System.out.println(Days.Sun.toString());
			break;

		}
	}
}
