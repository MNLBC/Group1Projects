package H1;

public enum WeekDays {

	SUN, MON, TUE, WED, THU, FRI, SAT;

	public static WeekDays valueOf(int i){
		for(WeekDays wd : WeekDays.values()){
			if(i == wd.ordinal())
				return wd;
		}
		return null; 
	}

}
