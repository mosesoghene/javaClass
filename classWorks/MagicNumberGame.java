import java.util.Scanner;

public class MagicNumberGame {
  public static void main(String[] args) {
    int num = 0/2;
    
    System.out.printf("%d%n", num);
    
    Scanner input = new Scanner(System.in);
    int x = input.nextInt();
    
    System.out.println("Triple the number you guessed (x * 3)");
    int step2 = x * 3;
    
    System.out.println("If the number is an even number, divide it by 2, if odd, add 1 and divide it by 2");
    
    if (step2 % 2 == 0) {
      
    }
  }
}
