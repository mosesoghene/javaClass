import java.util.Scanner;

public class TaxCalculator{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    String name;
    double earning;
    double tax = 0;
    
    while (true) {
    
      System.out.print("Enter Earning amount or enter -1 to get result \n>  ");
      earning = scan.nextDouble();
      if (earning == -1) break;
        
      System.out.print("Name \n>  ");
      name = scan.next();
      
      tax = (earning <= 30000) ? earning * 0.15 : earning * 0.20;
      
      System.out.printf("%s's Total tax: $%.2f%n", name, tax);
    }
    
  }
}
