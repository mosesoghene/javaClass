public class Vees {
	public static void main(String... args) {
		for (int row = 1; row <= 8; row++) {
			for (int number = row; number >= 1; number--) {
				System.out.print(" ");
			}

			for (int column = 1; column <= 1; column++) {
				System.out.print("*");
			}

			for (int number = 1; number <= 8 - row; number++) {
				System.out.print(" ");
			}
			for (int number = 1; number <= 8 - row; number++) {
				System.out.print(" ");
			}

			for (int column = 1; column <= 1; column++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}