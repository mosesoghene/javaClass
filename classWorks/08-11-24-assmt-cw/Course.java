import java.util.Scanner;

public class Course {
	
	public static void main(String... args) {
	Scanner scan = new Scanner(System.in);
	
	String year;

		System.out.print("""
		COURSES
		  > Math
		  > Science
		  > History
		
		Enter your course name: 
		> """);

		String course = scan.next();

		switch (course.toLowerCase()) {
			case "math" -> {
				System.out.print("""
				YEAR 
				 > Freshman
				 > Sophomore
				 > junior
				 > senior
				 
				Enter your year: 
				> """);
				
				year = scan.next();
				switch (year.toLowerCase()) {
					case "freshman" -> System.out.println("You are welcome freshman"); 
					case "sophomore"-> System.out.println("You learned and earned the sophomore badge"); 
					case "junior"-> System.out.println("Well, more is expected of your junior"); 
					case "senior" -> System.out.println("Stick to it, you will come out better");
					default -> System.out.println("invalid sh*t!!");
				} 
			}



			case "science" -> {
				System.out.print("""
				YEAR 
				 > Freshman
				 > Sophomore
				 > junior
				 > senior
				 
				Enter your year: 
				> """);
				
				year = scan.next();
				switch (year.toLowerCase()) {
					case "freshman" -> System.out.println("You are welcome freshman"); 
					case "sophomore"-> System.out.println("You learned and earned the sophomore badge"); 
					case "junior"-> System.out.println("Well, more is expected of your junior"); 
					case "senior" -> System.out.println("Stick to it, you will come out better");
					default -> System.out.println("invalid sh*t!!");
				} 
			}


			case "history" -> {
				System.out.print("""
				YEAR 
				 > Freshman
				 > Sophomore
				 > junior
				 > senior
				 
				Enter your year: 
				> """);
				
				year = scan.next();
				switch (year.toLowerCase()) {
					case "freshman" -> System.out.println("You are welcome freshman"); 
					case "sophomore"-> System.out.println("You learned and earned the sophomore badge"); 
					case "junior"-> System.out.println("Well, more is expected of your junior"); 
					case "senior" -> System.out.println("Stick to it, you will come out better");
					default -> System.out.println("invalid sh*t!!");
				} 
			}

			default -> System.out.println("invalid input");
			
		}
		
	}
}
