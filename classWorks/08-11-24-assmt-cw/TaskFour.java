import java.util.Scanner;

public class TaskFour {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int total = 0;
		int count = 1;
		System.out.print("enter a positive number: ");
		int number = input.nextInt();

		while (count <= number) {
			total += count;
			count++;
		}
		System.out.println(total);
	}
}