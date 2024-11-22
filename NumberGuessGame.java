import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame{
  public static void main(String[] args){
    int points = 0;
    int chances = 5;
    int computerNumber;
    int userNumber;
    int nOfQuestions = 0;
    int nOfIncorrect = 0;
    int nOfCorrect = 0;
    
    String endGame;
    
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    
    do{
      computerNumber = random.nextInt(100);
      nOfQuestions += 1;
      
      while (chances > 0){
        System.out.print("Guess the number between 0 - 100(both numbers inclusive) \n> ");
        userNumber = scanner.nextInt();
      
        if (userNumber < computerNumber){
          System.out.println("Too low");
          chances -= 1;
          nOfIncorrect += 1;
        } else if (userNumber > computerNumber) {
          System.out.println("Too high");
          chances -= 1;
          nOfIncorrect += 1;
        } else{
          System.out.println("Correct");
          points += 1;
          nOfCorrect += 1;
          break;
        }          
      }
      chances = 5;
      System.out.print("Do you want to continue? enter 'yes' or no  get results! \n> ");
      endGame = scanner.next();
      
    } while (endGame.equals("yes"));
    
    System.out.printf("Total Result: \n> %d Incorrect answers %n> %d Correct answers %n> %d Total Points %n +5 Points/correct -1 Point/incorrect");
  }
}
