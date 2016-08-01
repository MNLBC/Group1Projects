import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class w1d3_2 {

	public static void main(String[] args) {
		int n;

		System.out.print("Enter an integer : ");
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		System.out.println("Factorial of " + n + " is = " + facto(n));

	}

	public static int facto(int i) {
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
