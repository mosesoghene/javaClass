import java.util.Scanner;

public class Comparator{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter first number \n>  ");
    int firstNumber = scan.nextInt();
    System.out.print("Enter second number \n>  ");
    int secondNumber = scan.nextInt();
    
    
    System.out.println((firstNumber == secondNumber) ? "0" : (firstNumber > secondNumber) ? "1" :  "-1");
  }
}
