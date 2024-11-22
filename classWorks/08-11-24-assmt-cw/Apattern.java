public class Apattern {
	public static void main(String... args) {
		

		for (int row = 1; row <= 7; row++) {
			for (int space = 1; space <= 7 - row; space++) {
				System.out.print(" ");
			}

			for (int first = row; first >= 1; first--) {
				System.out.print(first);
			}

			for (int second = 2; second <= row; second++) {
				System.out.print(second);
			}
			System.out.println();
		}


		for (int rows = 6; rows >= 1; rows--) {
			for (int space = 1; space <= 7 - rows; space++) {
				System.out.print(" ");
			}
			for (int first = rows; first >= 1; first--) {
				System.out.print(first);
			}
			for (int second = 2; second <= rows; second++) {
				System.out.print(second);
			}
			System.out.println();
		}
	}
}