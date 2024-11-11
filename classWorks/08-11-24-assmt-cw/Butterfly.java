public class Butterfly {
	public static void main(String... args) {

		String asterisks = "*";

		for (int num = 1; num <= 9; num++) {
			for (int number = 1; number <= num - 2; number++) {
				System.out.print("*");
			}
			for (int number = 1; number <= 9 - num; number++) {
				System.out.print(" ");
			}
			for (int number = 1; number <= 9 - num; number++) {
				System.out.print(" ");
			}

			for (int number = 1; number <= num - 2; number++) {
				System.out.printf("*");
			}
			System.out.println();
		}


		for (int num = 1; num <= 8; num++) {
			for (int number = 8 - 2; number >= num; number--) {
				System.out.print("*");
			}
			for (int number = 1; number <= num; number++) {
				System.out.print(" ");
			}
			for (int number = 1; number <= num; number++) {
				System.out.print(" ");
			}
			for (int number = 8 - 2; number >= num; number--) {
				System.out.print("*");
			}


			System.out.println();
		}
	}
}
