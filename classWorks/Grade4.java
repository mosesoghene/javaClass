import java.util.Scanner;

public class Grade4{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
  System.out.print("Enter user grade: \n>  ");
  int grade = scan.nextInt();
    
    switch (grade){
      case 50 -> 
        System.out.println("C");
      case 70 ->
        System.out.println("B");
      case 100 ->
        System.out.println("A");
      default ->
        System.out.println("Well Done!!");
    }
    
  }
}
