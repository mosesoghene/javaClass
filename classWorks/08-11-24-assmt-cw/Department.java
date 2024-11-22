import java.util.Scanner;

public class Department {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter department [IT, HR, Finance]: ");
		String department = input.nextLine();

		switch (department.toUpperCase()) {
			case "IT": 
				System.out.print("1. Manager\n2. Analyst\n3. Intern\nwhat role >> ");
				int roleA = input.nextInt();
				switch (roleA) {
					case 1: System.out.println("hello manager"); break;
					case 2: System.out.println("hello analyst"); break;
					case 3: System.out.println("hello intern"); break;
					default: System.out.println("invalid input");
				} break;


			case "HR":
				System.out.print("1. Manager\n2. Analyst\n3. Intern\nwhat role >> ");
				int roleB = input.nextInt();
				switch (roleB) {
					case 1: System.out.println("hello manager"); break;
					case 2: System.out.println("hello analyst"); break;
					case 3: System.out.println("hello intern"); break;
					default: System.out.println("invalid input");
				} break;

			
			case "FINANCE":
				System.out.print("1. Manager\n2. Analyst\n3. Intern\nwhat role >> ");
				int roleC = input.nextInt();
				switch (roleC) {
					case 1: System.out.println("hello manager"); break;
					case 2: System.out.println("hello analyst"); break;
					case 3: System.out.println("hello intern"); break;
					default: System.out.println("invalid input");
				} break;


				
			default: System.out.println("invalid input");
		}
	}
}