import java.util.Scanner;

public class ExponentOfTwoNumbers{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter base number >> ");
    int baseNumber = scanner.nextInt();
    
    System.out.print("Enter exponent number >> ");
    int exponent = scanner.nextInt();
    
    int initialPower = 1;
    int totalPower = 1;
    
    while (initialPower <= exponent){
      totalPower *= baseNumber;
      initialPower += 1;
    }
    
    System.out.printf("%d raised to the power of %d => %d%n", baseNumber, exponent, totalPower);
  }
}
