
public class Factorial {

	public int calculate1(int i) {

		int total = 1;

		for (int b = 1; b <= i; b++) {
			total = total * b;
		}
		System.out.println("The factorial of " + i + " is :" + total);
		return total;
	}

}
