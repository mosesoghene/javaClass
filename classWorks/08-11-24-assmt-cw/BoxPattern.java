public class BoxPattern {
	public static void main(String... args) {
		for (int row = 1; row <= 1; row++) {
			for (int column = 1; column <= 5; column++) {
				System.out.print("* ");
			}
			System.out.println();

			for (int column = 1; column <= 6; column++) {
				System.out.println("*       *");
			}

			for (int column = 1; column <= 5; column++) {
				System.out.print("* ");
			}
		}
	}
}
