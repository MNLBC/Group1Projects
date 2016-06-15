package homework3;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int n;

		System.out.print("Enter an integer : ");
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		System.out.println("Factorial of " + n + " is = " + getFactorial(n));

	}

	public static int getFactorial(int i) {
		int c, fact = 1;
		if (i < 0)
			System.out.println("Number should be non-negative.");
		else {
			for (c = 1; c <= i; c++)
				fact = fact * c;
		}
		return fact;
	}
}
