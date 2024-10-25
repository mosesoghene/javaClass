import java.util.Scanner;
public class Nice {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter your First name: ");
    
    String name = scanner.next();
    
    System.out.print("Hi" + name + ", Nice to meet you!\n");
    System.out.printf("Hi %s, Nice to meet you!%n", name);
    System.out.println("Hi" + name + ", Nice to meet you!");
  }
}
