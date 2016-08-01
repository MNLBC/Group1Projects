package com.oocl.mnlbc.num2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 
 * @author barrepe
 *
 */

public class Ball {
	private BigDecimal radius;
	
	public Ball(BigDecimal radius) {
		this.radius = radius;
	}

	public BigDecimal getRadius() {
		return radius;
	}

	public void setRadius(BigDecimal radius) {
		this.radius = radius;
	}
	
	public BigDecimal calculateVolume(){
		BigDecimal BIG_PI = new BigDecimal(Math.PI);
		BigDecimal a = new BigDecimal(1.33333333333333333);
		return  radius.pow(3).multiply(a).multiply(BIG_PI).setScale(18, RoundingMode.UP);
	}
}
