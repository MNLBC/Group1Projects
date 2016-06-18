package w1_d5_2;

import java.math.BigDecimal;
import java.util.Scanner;

public class BallVolume {

	static final double PI = 3.141592653589793;
	

	public static void main(String[] args) {
		
		
		System.out.print("Enter Radius: ");
		Scanner input = new Scanner(System.in);
		double r = input.nextDouble();
		
		double volume = ((4.0 / 3.0) * PI * Math.pow(r,3));
		BigDecimal volume2 = new BigDecimal(volume);

		System.out.println("The volume is " + volume2);

	}
}