import java.util.Scanner;

public class Vote {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		System.out.print("enter your age: ");
		int age = input.nextInt();

		if (age >= 18) System.out.println("Can vote");
		if (age >= 16) System.out.println("can drive");
		if (age >= 21) System.out.println("can drink");
	}
}