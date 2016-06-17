import java.math.BigDecimal;
import java.util.Scanner;

public class VolumeOfBall {
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
	    BigDecimal r = new BigDecimal(0);
	    BigDecimal  pi = new BigDecimal(3.1415926535);
	    BigDecimal  fraction = new BigDecimal(1.3333333333);
	    
	    System.out.println("Enter radius: ");
	    r = scanner.nextBigDecimal();
	    
	    BigDecimal answer = fraction.multiply(pi.multiply(r.pow(3)));
	    BigDecimal newAnswer = answer.setScale(16, BigDecimal.ROUND_DOWN);
	    
	    System.out.println("Volume: " + newAnswer);
	}
}
