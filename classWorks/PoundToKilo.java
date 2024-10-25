import java.util.Scanner;

public class PoundToKilo {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number in pound >> ");
    int data = input.nextInt();
    double sum = (double) data * 0.454;
    System.out.printf("Sum = %f KGs is %n", sum);
  }
}
