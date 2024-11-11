import java.util.Scanner;

public class Menu {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("""
			1) Add
			2) View
			3) Delete
			4) Quit
			""");
			choice = input.nextInt();
			switch (choice) {
			  case 1 -> System.out.println("Add selected");
			  case 2 -> System.out.println("View selected");
			  case 3 -> System.out.println("Delete selected");
			  case 4 -> System.out.println("Quitting...");
			  default -> System.out.println("Yeah, that sh*t you just typed, makes no sense!!!");
			  
			}
		} while(choice != 4);
	}
}
