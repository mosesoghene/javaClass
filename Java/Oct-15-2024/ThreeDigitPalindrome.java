import java.util.Scanner;

public class ThreeDigitPalindrome{
  public static void main(String[] args){
    Scanner inputEngine = new Scanner(System.in);
  
    System.out.print("Enter a 3 digit integer(e.g 121, 435) >> ");
    int data = inputEngine.nextInt();
  
    if (data > 100 && data < 1000 ){
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
