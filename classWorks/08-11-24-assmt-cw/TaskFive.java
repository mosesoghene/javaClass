import java.util.Scanner;

public class TaskFive {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		System.out.print("enter the range: ");
		int range = input.nextInt();
		int counter = 1;

		while (counter <= range) {
			if (counter % 7 == 0 && counter % 13 == 0) {
				System.out.println(counter);
				break;
			}
			counter++;
		}
	}
}
