import java.util.Scanner; 

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("input number of terms \n> ");
		int number = scanner.nextInt();

		for (int i = 0; i <= number; i++) {
			int product = number * i;
			System.out.printf("%d x %d = %d%n", number, i, (number * i));
		}
	}

}
