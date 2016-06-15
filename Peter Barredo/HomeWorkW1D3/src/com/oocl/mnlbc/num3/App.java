package com.oocl.mnlbc.num3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	Pattern p;
	Matcher matcher;
	public boolean checkEmail(String emailInput) {
		p = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		matcher = p.matcher(emailInput);
		return matcher.find();
	}

	public boolean checkMobilePhone(String mobilePhone) {
		 p  = Pattern.compile("^(?:(?:\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$");
		 matcher = p.matcher(mobilePhone);
		 return matcher.find(); 
	}

	public String replaceChar(String word) {
		return word.replaceAll("([a])", "A");
	}

	public String getDateFromString(String dateStr) {
		return dateStr.split("\\s")[1];
	}
}
