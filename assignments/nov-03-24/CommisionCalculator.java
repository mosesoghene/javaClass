import java.util.Scanner;

public class CommisionCalculator{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    double totalSales = 0;
    double basePay = 200;
    double sale;
    
    System.out.println("Enter item amount or enter -1 to get result ");
    do {
    
    System.out.print(">  ");
    sale = scan.nextDouble();
    totalSales += sale;
    
    } while (sale != -1);
    
    System.out.printf("Total pay: $%.2f%n", basePay + totalSales * 0.09);
  }
}
