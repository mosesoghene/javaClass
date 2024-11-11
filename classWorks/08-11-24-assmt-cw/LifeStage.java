import java.util.Scanner;

public class LifeStage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter your age: ");
		int age = input.nextInt();

		if (age > 0 && age <= 12) System.out.println("Child");
		else if (age >= 13 && age <= 17) System.out.println("Teen");
		else if (age >= 18 && age <= 64) System.out.println("Adult");
		else System.out.println("Senior");
	}
}