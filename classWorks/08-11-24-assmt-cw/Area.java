import java.util.Scanner;

public class Area {
  static Scanner scan = new Scanner(System.in);
  static int MenuResponse;
  static String response;
  
	public static void main(String... args) {
		menu();
	}

	public static void menu() {
		System.out.println("""
		MENU
		  1. Circle
		  2. Rectangle
		  3. Triangle
		  4. exit
		  > """);

		MenuResponse = scan.nextInt();
		switch (MenuResponse) {
			case 1 -> {
				System.out.print("Do you want to enter the value? Y/N(get a default value):\n> ");
				String response = scan.next();
				if (response.equalsIgnoreCase("y")) {
					System.out.print("enter the radius: ");
					int radius = scan.nextInt();
					circle(radius);
				} 
				else if (response.equalsIgnoreCase("n")) {
					circle(20);
				} else {				  
					System.out.println("Invalid input Y/N");
				}
      }

			case 2 -> {
				System.out.print("Do you want to enter the value? Y/N(get a default value):\n> ");
				String response = scan.next();
				if (response.equalsIgnoreCase("y")) {
					System.out.print("Enter the length:\n> ");
					int length = scan.nextInt();
					System.out.print("Enter the breadth:\n> ");
					int breadth = scan.nextInt();
					rectangle(length, breadth);
				} 
				else if (response.equalsIgnoreCase("n")) {
					rectangle(20, 40);
				} else {				  
					System.out.println("Invalid input Y/N");
				}
			}
			

			case 3 -> {
				System.out.print("do you want to enter a value? Y/N(get a default value):\n> ");
				String response = scan.next();
				if (response.equalsIgnoreCase("y")) {
					System.out.print("enter the base:\n> ");
					int base = scan.nextInt();
					System.out.print("Enter the height:\n> ");
					int height = scan.nextInt();
					triangle(base, height);
				} 
				else if (response.equalsIgnoreCase("n")) {
					triangle(20, 40);
				} else {				  
					System.out.println("Invalid input Y/N");
				}
			}

			case 4 -> System.out.println("exiting... ");

			default -> System.out.println("invalid input");
		}
	}


	public static void circle(int radius) {
		double area = 3.14 * radius;
		System.out.println(area);
	}


	public static void rectangle(int length, int breadth) {
		int area = length * breadth;
		System.out.println(area);
	}


	public static void triangle(int base, int height) {
		int area = (base * height) / 2;
		System.out.println(area);
	}

	
}
