package com.oocl.mnlbc.num1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author barrepe
 *
 */

enum WeekDays {
	Mon, Tue, Wed, Thur, Fri, Sat, Sun
}

public class App {

	public static void main(String[] args) {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd EEE HH:mm:ss");
		System.out.println(sdf.format(dt));
		
		@SuppressWarnings("deprecation")
		String weekDay = WeekDays.values()[dt.getDay() - 1].toString();
		
		 switch(weekDay){
		 	case "Mon": System.out.println("You will attend a wedding today");
		 		break;
		 	case "Tue": System.out.println("You will watch Game of Thrones today");
		 		break;
		 	case "Wed": System.out.println("You will date your girlfriend today");
		 		break;
		 	case "Thu": System.out.println("You will go to gym today");
		 		break;
		 	case "Fri": System.out.println("You will practice chinese words today");
		 		break;
		 	case "Sat": System.out.println("You will meet Dr.Magneto today");
		 		break;
		 	case "Sun": System.out.println("You will go to war with Avengers #TeamCap");
		 		break;
		 }
	}

}
