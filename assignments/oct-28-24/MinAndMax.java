import java.util.Scanner;

public class MinAndMax {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
    int largest = 0;
	  int smallest = 0;
	  int choice;
	  
    do {
      System.out.println("\nEnter 0 to get result");
		  System.out.print("Enter a number \n> ");
		  
		  choice = scanner.nextInt();

			if (choice > largest) {
				largest = choice;
			} else if (choice < smallest) {
				smallest = choice;
			}	
			
		} while (choice != 0);
			
		System.out.printf("Largest: %d%nSmallest: %d%n", largest, smallest);
		
	}
}
