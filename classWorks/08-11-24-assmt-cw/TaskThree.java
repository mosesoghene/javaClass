import java.util.Scanner;

public class TaskThree {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		System.out.print("enter two numbers: ");
		int first = input.nextInt();
		int second = input.nextInt();
		int sum = 0;
		if (second > first) {
			int count = first + 1;
			while (count < second) {
				if (count % 2 == 0) {
					sum += count;
				}

				count++;
			}
			System.out.println(sum);
		}
	}
}