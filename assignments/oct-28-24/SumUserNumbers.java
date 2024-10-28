import java.util.Scanner;

public class SumUserNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			int firstNumber = 0;
			int secondNumber = 0;
			int choice;

		do {
			System.out.print("enter two numbers to get the sum: \n> ");
			firstNumber = scanner.nextInt();
			System.out.print("> ");
			secondNumber = scanner.nextInt();
			
			System.out.println("sum: " + (firstNumber + secondNumber));
			System.out.print("do you want to continue? enter 1 to continue or 0 to quit: \n> ");
			
			choice = scanner.nextInt();
			
		} while (choice != 0);
	}
}
