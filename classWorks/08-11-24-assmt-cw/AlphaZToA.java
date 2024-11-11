public class AlphaZToA {
	public static void main(String... args) {
		
		char letter = 'z';
		for (int count = 1; count <= 26; count++) {
			System.out.print(letter-- + " ");
		}
	}
}
