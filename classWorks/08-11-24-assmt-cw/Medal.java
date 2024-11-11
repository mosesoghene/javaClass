import java.util.Scanner;

public class Medal {
	public static void main(String... args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter rank number:\n> ");
		int number = scan.nextInt();

		switch (number) {
			case 1 -> System.out.println("gold medal"); 
			case 2 -> System.out.println("silver medal"); 
			case 3 -> System.out.println("bronze medal"); 
			case 4 -> System.out.println("New comer"); 
			default -> System.out.println("invalid input");
		}
	}
}
