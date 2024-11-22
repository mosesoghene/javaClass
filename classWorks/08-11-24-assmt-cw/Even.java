import java.util.Scanner;

public class SumOfEven {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter two numbers:\n> ");
		int first = input.nextInt();
		System.out.print("> ");
		int second = input.nextInt();
		int sum = 0;
		if (second > first) {
			for (int count = first + 1; count <= second - 1; count++) {
				if (count % 2 == 0) {
					sum += count;
				}
			}
			System.out.println(sum);
		}
	}
}
