public class Atpattern {
	public static void main(String... args) {
		for (int row = 1; row <= 6; row++) {
			for (int space = 1; space <= 6 - row; space++) {
				System.out.print(" ");
			}
			for (int column = 1; column <= row; column++) {
				System.out.print("@");
			}
			System.out.println();
		}
	}
}