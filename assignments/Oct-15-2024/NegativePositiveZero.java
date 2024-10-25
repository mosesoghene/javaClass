import java.util.Scanner;

public class NegativePositiveZero{
  public static void main(String[] args){
    int negativeCount = 0;
    int positiveCount = 0;
    int zeroCount = 0;
    
    Scanner scanner = new Scanner(System.in);
    
    int loopCount = 5;
    
    do {
      System.out.print("Enter an integer number(Positive, Negative or Zero): ");
      int dataInput = scanner.nextInt();
      if (dataInput > 0){
        positiveCount += 1;
        loopCount -= 1;
      } else if (dataInput < 0){
        negativeCount += 1;
        loopCount -= 1;
      } else {
        zeroCount += 1;
        loopCount -= 1;
      }
    } 
    while (loopCount > 0);
    
    System.out.printf("Total Negative Values: %d%nTotal Positive Values: %d%nTotal Zero Values: %d%n", negativeCount, positiveCount, zeroCount);
  }
}
