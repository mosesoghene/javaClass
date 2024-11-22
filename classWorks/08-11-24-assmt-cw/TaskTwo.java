import java.util.Scanner;

public class TaskTwo {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;

		while (choice != 4) {
			System.out.println("""
			1) Add
			2) View
			3) Delete
			4) Quit
			""");
			choice = input.nextInt();
		}
	}
}