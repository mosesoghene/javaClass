/**
@AUTHOR: Moses Oghene (LocalDevv)

Program to check if a 3 digit number between 0 - 1000 is a palindrome.
program prompts user to enter a 3 digit integer, stores integer and checks if integer is a palindrome
*/

import java.util.Scanner;

public class ThreeDigitPalindrome{

  /*
    Main Method of class housing all 
    instructions to check if number is a plaindrome
  */
  public static void main(String[] args){
    Scanner inputEngine = new Scanner(System.in);
  
    System.out.print("Enter a 3 digit integer(e.g 121, 435) >> ");
    int data = inputEngine.nextInt();
  
    // Check if 'data' input is within needed range
    if (data > 100 && data < 1000 ){
    
      // Check if 'data' is a palindrome
      if (data % 10 == data / 100){
        System.out.printf("%d is a palindrome!%n", data);
      } else {
        System.out.printf("%d is not a palindrome!%n", data);
      }
    } else {
      System.out.printf("%d is out of range!!!%n", data);
    }
  }
}
