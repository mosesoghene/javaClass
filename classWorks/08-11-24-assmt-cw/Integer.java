import java.util.Scanner;

public class Integer {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int total = 0;
		System.out.print("enter a positive number: ");
		int number = input.nextInt();

		for (int count = 1; count <= number; count++) {
			total += count;
		}

		System.out.println(total);
	}
}