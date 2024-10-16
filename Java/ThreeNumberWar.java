import java.util.Scanner;

public class ThreeNumberWar {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter num1: ");
    int num1 = input.nextInt();
    
    System.out.print("Enter num2: ");
    int num2 = input.nextInt();
    
    System.out.print("Enter num3: ");
    int num3 = input.nextInt();
    
    int sum = num1 + num2 + num3;
    int product = num1 * num2 * num3;
    int average = sum / 3;
    
    int smallest = 0;
    int largest = 0;
    
    if (num1 < num2 && num1 < num3) {
      smallest = num1;
    } else if (num2 < num3){
      smallest = num2;
    }else {
      smallest = num3;
    }
    
    if (num1 > num2 && num1 > num3) {
      largest = num1;
    } else if (num2 > num3){
      largest = num2;
    }else {
      largest = num3;
    }
    
    
    
    System.out.printf("Sum: %d %nProduct: %d %nAverage: %d %nLargest: %d %nSmallest: %d%n", sum, product, average, largest, smallest);
  }
}
