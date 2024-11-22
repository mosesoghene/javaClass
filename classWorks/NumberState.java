import java.util.Scanner;
public class NumberState{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int userNumber;
    
    for (int count = 1; count <= 3;){
      System.out.print("Enter a number \n> ");
      userNumber = scanner.nextInt();
      if (userNumber > 0){
        System.out.println("Number positive");
      } else if (userNumber < 0){
        System.out.println("Number negative");        
      } else{
        System.out.println("Number Zero"); 
      }
      
      count++;
      
    }
  }
}
