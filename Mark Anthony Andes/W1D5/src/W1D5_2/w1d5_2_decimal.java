package W1D5_2;

import java.text.DecimalFormat;

public class w1d5_2_decimal {
	public static void main(String[] args) {
		Double radius = 23.0;

		Double volume = (4 * Math.PI * radius) / 3;
		DecimalFormat decimalFormat = new DecimalFormat("#,###.0000000000000000");

		System.out.println("Calculate "+decimalFormat.format(volume));
	}
}
