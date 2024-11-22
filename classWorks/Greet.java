import java.util.Scanner;

public class Greet{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
      String mainMenu = """
      Can I greet?
      please choose one option
        1. English
        2. Yoruba
        3. Ibo
        >> """;
        
      String dayTime = """
      Morning
      Afternoon
      Evening
      > """;
      
      System.out.print(mainMenu);
      int mainMenuResponse = scan.nextInt();
      
      switch (mainMenuResponse){
        case 1: 
          System.out.println(dayTime); break;
        case 2: System.out.println("Greetings in Yoruba"); break;
        case 3: System.out.println("Greetings in Ibo"); break;
        default: System.out.println("Greetings in an unknown language"); break;
      }
      
      
    }
}
