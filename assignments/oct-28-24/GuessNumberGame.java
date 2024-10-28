import java.util.Scanner;

public class GuessNumberGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int userGuess = 0;
		int computerGuess = (int) (Math.random() * 10);

		while (userGuess != computerGuess) {
			System.out.print("Guess a number \n> ");
			userGuess = scanner.nextInt();

			if (userGuess > computerGuess) {
				System.out.println("Too high!, try again");
			} else if (userGuess < computerGuess) {
				System.out.println("Too low, try again");
			} else if (userGuess == computerGuess) {
				System.out.println("Way to go champ, you got it!");
			}
		}
	}
}
