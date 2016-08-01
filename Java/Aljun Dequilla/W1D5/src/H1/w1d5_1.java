package H1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class w1d5_1 {

	/**
	 * @author DEQUIAL
	 * 
	 * This is main class for W1D5_1
	 * 
	 * @param 	args[]	Main Parameters 
	 */
	public static void main(String[] args) {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.dd.MM EEE HH:mm:ss");
		String dateNow = formatter.format(d);
		System.out.println(dateNow);
		agendToday(d.getDay());

	}
	/**
	 * This is a method for printing the message depending on the day
	 * 
	 * @param 	d		Display the message	
	 */

	public static void agendToday(int d) {
		WeekDays day = WeekDays.valueOf(d);
		switch (day) {
		case FRI:
			System.out.println("Sample Projects and Exam!?");
			break;

		case SAT:
		case SUN:
			System.out.println("REST! BREAK! FREE!");
			break;

		default:
			System.out.println("Lesson...");
			break;
		}
	}
}