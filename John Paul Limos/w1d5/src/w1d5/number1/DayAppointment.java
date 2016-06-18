package w1d5.number1;

import java.util.Date;

public class DayAppointment {
	Day day;

	enum Day {
	    SUN, MON, TUE, WED,
	    THU, FRI, SAT 
	    

	}

	public DayAppointment(Day day) {
		this.day = day;
	}
	public static void main(String[] args) {
		Date date = new Date();
		String dayToday = (date.toString().substring(0, 3)).toUpperCase();
		System.out.println("Today is " + Day.valueOf(dayToday));
		DayAppointment dayNow = new DayAppointment(Day.valueOf(dayToday));
		dayNow.appointment();
	}
	
	public void appointment() {
		switch (day) {
		case MON:
			System.out.println("Go To Work");
			break;
		case TUE:
			System.out.println("Go To Work.");
			break;
		case WED:
			System.out.println("Go To Work.");
			break;
		case THU:
			System.out.println("Go To Work.");
			break;
		case FRI:
			System.out.println("Go To Work.");
			break;
		case SAT:
			System.out.println("No Schedule Today");
			break;
		case SUN:
			System.out.println("No Schedule Today");
			break;
		}
	}
}