import java.util.Scanner;

public class NegativePositiveZeroCounter {
  public static void main(String[] args){
    int negativeCounter;
    negativeCounter = 0;
    int positiveCounter;
    positiveCounter = 0;
    int zeroCounter;
    
    int numberCounter;
    numberCounter = 0;
    
    Scanner scanner = new Scanner(System.in);
    
    while (numberCounter <= 5){
      System.out.print("Enter an integer number >> ")
      number = scanner.nextInt();
      
      if (number < 0) {
        negativeCounter++;
      } else if (number == 0){
        positiveCounter++;
      } else {
        zeroCounter++;
      }
      
      numberCounter++
    }
  }
}
