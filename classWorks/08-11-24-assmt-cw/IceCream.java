import java.util.Scanner;

public class IceCream {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		mainMenu(input);
	}

	
	public static void mainMenu(Scanner input) {
		System.out.println("""
		1. Ice cream
		2. Sundae
		3. Shakes
		4. Exit
		""");
		String iceCream = "Ice cream";
		String sundae = "Sundae";
		String shakes = "Shakes";

		int choice = input.nextInt();
		switch (choice) {
			case 1: flavour(input, iceCream); break;
			case 2: flavour(input, sundae); break;
			case 3: flavour(input, shakes); break;
			case 4: System.out.println("exiting..."); break;
			default: System.out.println("invalid input"); break;
		}
	}

	public static void flavour(Scanner input, String choice) {
		System.out.println("""
		1. Chocolate
		2. Vanilla
		3. Strawberry
		4. back
		""");

		int choiceTwo = input.nextInt();
		switch (choiceTwo) {
			case 1: System.out.printf("serving a chocolate %s right away...", choice); break;
			case 2: System.out.printf("serving a vanilla %s right away...", choice); break;
			case 3: System.out.printf("serving a strawberry %s right away...", choice); break;
			case 4: mainMenu(input); break;
			default: System.out.println("invalid input");
		}
	}
}



