import java.util.Scanner;

public class FeetToMeter {
  public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number in feets >> ");
    int data = input.nextInt();
    double sum = (double) data * 0.305;
    System.out.printf("Sum = %f meters %n", sum);
  }
}
