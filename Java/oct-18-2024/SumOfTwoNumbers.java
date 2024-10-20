import java.util.Scanner;

public class SumOfTwoNumbers{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int response = 1;
    int userResponse;
    do{
      System.out.print("Enter first number >> ");
      double firstNumber = scanner.nextDouble();
      
      System.out.print("Enter second number >> ");
      double secondNumber = scanner.nextDouble();
      
      double sumOfNumbers = firstNumber + secondNumber;
      
      System.out.printf("Sum of %.2f + %.2f => %.2f%n", firstNumber, secondNumber, sumOfNumbers);
      
      System.out.print("Do you want to continue? Type 1 to continue >> ");
      userResponse = scanner.nextInt();
      

      System.out.println();
      
    } while (userResponse == response);
    
    System.out.println("Program Terminated!!!");
  }
}
