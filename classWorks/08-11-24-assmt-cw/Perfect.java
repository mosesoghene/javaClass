import java.util.Scanner;

public class Perfect {
	public static void main(String... args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter a number to check if its a perfect number:\n> ");
		int number = scan.nextInt();
		
		getPerfectNumber(number);
	}

	public static void getPerfectNumber(int number) {
		int divisors = 0;

		for (int count = 1; count <= (number / 2); count++) {
			if (number % count == 0) divisors += count;
		}
		
		System.out.println((number == divisors) ? "perfect number" : "not perfect");
		
	}
}
