import java.util.Scanner;

public class SingleSelection{
  public static void main(String[] args){
  
    Scanner scanner = new Scanner(System.in);
    int sum;
    System.out.print("First number \n> ");
    int number1 = scanner.nextInt();
    System.out.print("Second number \n> ");
    int number2 = scanner.nextInt();
    
    System.out.println((number1 > number2) ? "Great" : "");
    
    
	  System.out.println("you are doing well...");
    
    sum = number1 + number2

		System.out.println((sum > 50) ? "Even is greater" : "");

  }
}
