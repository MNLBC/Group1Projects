public class Factorial {

    public static int calculateFactorial(int n) {
    	int value = 1;
    	for (int a = 1; a <= n; a++) {
			value = value * a;
		}
		//System.out.print(value);
		return value;
    }

}
