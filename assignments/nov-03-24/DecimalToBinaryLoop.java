import java.util.Scanner;

public class DecimalToBinaryLoop{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    
    int largest = 0;
    int nextLargest = 0;
    
    System.out.print("Enter a number \n>  ");
    int number = scan.nextInt();
    int remainder;
    int multiple = 0;
    int decimal = 0;
    
    do {
      remainder = number % 10;
      decimal += remainder * Math.pow(2, multiple);
      number = number / 10;
      multiple++;
    } while (number > 0);
    
    System.out.printf("Decimal: %d\n", decimal);
  }
}
