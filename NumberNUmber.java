import java.util.Scanner;

public class NumberNumber{
  public static void main(String[] args){
  
    Scanner scanner = new Scanner(System.in);
    int sum;
    System.out.print("First number \n> ");
    int number1 = scanner.nextInt();
    System.out.print("Second number \n> ");
    int number2 = scanner.nextInt();
    
    if (number1 > number2){
    	System.out.println("Greater");
    	sum = number1 + number2
    }
    
	System.out.println("You are doing well");
	
	if (sum > 50) {
		System.out.println("Greater");
	}
  }
}
