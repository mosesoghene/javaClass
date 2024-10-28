import java.util.Scanner;

public class VowelChecker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

		System.out.print("Input a single letter, I will tell you if it's vowel or not >> ");
		String letter = scanner.next();


		if (letter.length() == 1) {
			if (letter.matches("[a-zA-Z]+")) {
				if (letter.matches("[aeiouAEIOU]")) {
					System.out.printf("'%s' is a vowel letter%n", letter);
				} else {
					System.out.printf("'%s' is a consonant letter%n", letter);
				}
			} else {
				System.out.printf("'%s' is an invalid input%n", letter);
			}
		} else {
			System.out.println("length is more than one");
		}
	}
}
