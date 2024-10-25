import java.util.Scanner;
public class MinAndMaxNumber{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int userNumberInput = scanner.nextInt();

		int largest = userNumberInput;
		int smallest = userNumberInput;

    String continuePrompt;
		do {
			System.out.print("Enter number => ");
			userNumberInput = scanner.nextInt();

			if (number > largest){
				largest = userNumberInput;
			}

			if (number < smallest){

				smallest = userNumberInput;
			}

			System.out.print("Is that all the numbers? yes/no => ");
			continuePrompt = scanner.next();

		} while (continuePrompt.equals("no"));

		System.out.printf("Largest number => %d%n", largest);
		System.out.println("Smallest number => %d%n", smallest);

	}
}
