import java.util.Scanner;
public class NumberState2{
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    
    String terminator;
    
    do {
      System.out.print("Enter a number \n> ");
      int userNumber = scanner.nextInt();
      if (userNumber > 0){
        System.out.println("Number positive");
      } else if (userNumber < 0){
        System.out.println("Number negative");        
      } else{
        System.out.println("Number Zero"); 
      }
      
      System.out.print("Enter 'yes' (in lowercase) to contiune \n> "); 
      terminator = scanner.next();
    } while (terminator.equals("yes"));
  }
}
