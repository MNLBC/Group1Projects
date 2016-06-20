package w1d5.number2;

import java.math.BigDecimal;
import java.util.Scanner;

public class BallVolume {

	 static final double pi = 3.14159265358979324;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Input Radius: ");
		double radius = input.nextDouble();
		double volume =((4.0/3.0) * pi * Math.pow(radius, 2));
		BigDecimal bgDecimal = new BigDecimal(volume);
		System.out.println(bgDecimal);
	}
}
