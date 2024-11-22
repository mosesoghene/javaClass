public class Reverse {
	public static void main(String... args) {
		
		for (int count = 12; count >= 1; count--) {
			for (int counter = 12; counter >= 1; counter--) {
				System.out.printf("%5d * %5d : %5d\t", counter, count, counter * count);
			}
			System.out.println();
		}
	}
}