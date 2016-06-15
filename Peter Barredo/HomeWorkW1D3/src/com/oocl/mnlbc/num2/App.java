package com.oocl.mnlbc.num2;

public class App {
	public int getFactorial(int n){
		 int result = 1;
	       for (int i = 1; i <= n; i++) {
	           result = result * i;
	       }
		return result;
	}
}
