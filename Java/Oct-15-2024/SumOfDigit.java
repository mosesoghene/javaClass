import java.util.Scanner;

public class SumOfDigit {
  public static void main(String[] args){
    System.out.print("Enter number between 0 - 1000: ");
    Scanner input = new Scanner(System.in);
    int data = input.nextInt();
    
    if (data > 0 ) {
      if (data > 99 ) {
        int lastNum = data % 10;
        int tempData = data / 10;
        int midNum = tempData % 10;
        int firstNum = tempData / 10;
        int total = firstNum + midNum + lastNum;
        System.out.printf("Sum: %d%n", total);
      } else {
        int lastNum = data % 10;
        int firstNum = data / 10;
        int total = firstNum + lastNum;
        System.out.printf("Sum: %d%n", total);
      }
    } else {
      System.out.println("Value Out of Range");
    }
  }
}
