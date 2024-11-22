import java.util.Scanner;

public class Greet2{
  public static void main(String[] args){
    int count = 0;
    for (; count < 5 ;){
      System.out.println("A ");
    }
    
    Scanner scan = new Scanner(System.in);
    int response;
      String mainMenu = """
      Can I greet?
      please choose one option
        1. English
        2. Yoruba
        3. Ibo
        >> """;
        
      String dayTime = """
      1. Morning
      2. Afternoon
      3. Evening
      > """;
      
      System.out.print(mainMenu);
      int mainMenuResponse = scan.nextInt();
      
      switch (mainMenuResponse){
        case 1: 
          System.out.println(dayTime);
          response = scan.nextInt();
          switch (response){
            case 1: System.out.println("Good morning in English"); break;
            case 2: System.out.println("Good afternoon in English"); break;
            case 3: System.out.println("Good evening in English"); break;
            default: System.out.println("Invalid time of day"); break;
          }
          break;
        
        case 2: 
          System.out.println(dayTime);
          response = scan.nextInt();
          switch (response){
            case 1: System.out.println("Good morning in Yoruba"); break;
            case 2: System.out.println("Good afternoon in Yoruba"); break;
            case 3: System.out.println("Good evening in Yoruba"); break;
            default: System.out.println("Invalid time of day"); break;
          }
          break;
          
        case 3: 
          System.out.println(dayTime);
          response = scan.nextInt();
          switch (response){
            case 1: System.out.println("Good morning in Ibo"); break;
            case 2: System.out.println("Good afternoon in Ibo"); break;
            case 3: System.out.println("Good evening in Ibo"); break;
            default: System.out.println("Invalid time of day"); break;
          }
          break;
        default: System.out.println("Greetings in an unknown language"); break;
      }
      
      
    }
}
