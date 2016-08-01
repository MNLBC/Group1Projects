
public class Factorial {
	public static int factorMe(int n) {
		int factor = 1;
		for (int i = 1; i <= n; i++) {
			factor = factor * i;
		}
		return factor;
	}
}
