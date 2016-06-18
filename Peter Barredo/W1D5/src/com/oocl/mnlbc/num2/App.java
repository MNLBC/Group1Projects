package com.oocl.mnlbc.num2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author barrepe
 *
 */
public class App {

	public static void main(String[] args) {
		
		BigDecimal radius = new BigDecimal(4.12345678912345612389);
		Ball ball = new Ball(radius);
		System.out.println(ball.calculateVolume());
		
	}

}
