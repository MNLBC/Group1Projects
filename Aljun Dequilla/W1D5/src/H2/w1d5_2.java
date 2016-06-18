package H2;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class w1d5_2 {

	static final double PI = Math.PI;
	/**
	 * @author DEQUIAL
	 * 
	 * This is main class for W1D5_2
	 * 
	 * @param args[] Main Parameters 
	 */
	public static void main(String[] args) {
		double r = 5;
		System.out.println("Radius of the Sphere: " + r);
		System.out.println("Area of the Sphere: " + area(r));
	}

	/**
	 * This is a method for getting the area.
	 * 
	 * @param 	r The Radius of the ball.
	 * @return 	BigDecimal The Area of the ball.
	 */
	public static BigDecimal area(double r) {

		DecimalFormat df = new DecimalFormat(".################");
		return new BigDecimal(df.format((4/3) * PI * Math.pow(r, 2.0)));

	}
}
