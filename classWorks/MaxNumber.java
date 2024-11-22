import java.util.Scanner;
public class MaxNumber{
	public static void main(String[] args){
	  Scanner scanner = new Scanner(System.in);
	  
	  System.out.print("Enter a number \n> ");
	  int firstNumber = scanner.nextInt();
	  System.out.print("> ");
	  int secondNumber = scanner.nextInt();
	  System.out.print("> ");
	  int thirdNumber = scanner.nextInt();
	  
	  if (firstNumber > secondNumber && firstNumber > thirdNumber){
	    System.out.println(firstNumber);
	  } else if (secondNumber > thirdNumber){
	    System.out.println(secondNumber);
	  } else {
	    System.out.println(thirdNumber);
	  }
	}
}
