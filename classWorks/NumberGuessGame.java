import java.util.Scanner;

public class NumberGuessGame{
  public static void main(String[] args){
    int computerNumber = 75;
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Guess the number between 0 - 100(both numbers inclusive) \n> ");
    int userNumber = scanner.nextInt();
    
    System.out.println((userNumber > computerNumber) ? "Too high" : (userNumber < computerNumber) ? "Too low" : "Correct");
  }
}
