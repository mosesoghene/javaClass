import java.util.Scanner;

public class MultipleOftwo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter num1: ");
    int num1 = input.nextInt();
    
    System.out.print("Enter num2: ");
    int num2 = input.nextInt();
    
    int trippled = num1 * 3;
    int doubled = num2 * 2;
    
    if (trippled % doubled == 0){
      System.out.printf("%d trippled is a multiple of %d doubled %n", num1, num2);
    }else {
      System.out.printf("%d trippled is not a multiple of %d doubled %n", num1, num2);
    }
  }
}
