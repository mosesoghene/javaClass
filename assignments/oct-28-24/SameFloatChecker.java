import java.util.Scanner;
import java.text.DecimalFormat;

public class SameFloatChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("enter two decimal numbers: \n> ");
		double firstNumber = scanner.nextDouble();
		
		System.out.print("> ");
		double secondNumber = scanner.nextDouble();

		if (isSameFloat(firstNumber, secondNumber)) {
			System.out.printf("The two decimal numbers are the same: %.3f and %.3f%n", firstNumber, secondNumber);
		} else {
			System.out.printf("The two decimal numbers are not the same: %.3f and %.3f%n", firstNumber, secondNumber);
		}
	}
	
	public static boolean isSameFloat(double a, double b){
	  DecimalFormat df = new DecimalFormat("0.000");
	  String valueOne = df.format(a);
	  a = Double.parseDouble(valueOne);
	  
	  String valueTwo = df.format(b);
	  b = Double.parseDouble(valueTwo);
	  
	  return (a == b) ? true : false;
	}
}
