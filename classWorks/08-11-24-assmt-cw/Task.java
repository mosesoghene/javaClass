public class Task {
	public static void main(String... args) {
		for (int row = 1; row <= 5; row++) {
			for (int column = 1; column <= row; column++) {
				System.out.print(column);
			}
			System.out.println();
		}

		for (int row = 4; row >= 1; row--) {
			for (int column = 1; column <= row; column++) {
				System.out.print(column);
			}
			System.out.println();
		}
	}
}