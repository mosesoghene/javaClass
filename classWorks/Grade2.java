import java.util.Scanner;

public class Grade2{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int count = 5;
    
    while (count > 0){
      System.out.print("Enter user grade: \n>  ");
      int grade = scan.nextInt();
      if (grade < 50 ){
        System.out.println("D");
      }
      
      if (grade >= 50 && grade <= 60){
        System.out.println("C");
      }
      
      if (grade > 60 && grade <= 80){
        System.out.println("B");
      }
      
      if (grade > 80 && grade <= 100){
        System.out.println("A");
      }
      
      count--;
    }
    
  }
}
