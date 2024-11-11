import java.util.Scanner;

public class Tones{
  
  public static void menu(){
    Scanner scan = new Scanner(System.in);
    int menuResponse;
      String mainMenu = """
      Tones
        1. Ringing tone
        2. Ringing volume
        3. Incoming call alert
        4. Composer
        5. Message alert tone
        6. Keypad tones
        7. Warning and game tones
        8. Vibrating alert
        9. Screen saver
        >> """;
      
      System.out.print(mainMenu);
      menuResponse = scan.nextInt();
      
      switch (menuResponse){
        case 1: System.out.print("Ringing tone"); break;
        case 2: System.out.print("Ringing volume"); break;
        case 3: System.out.print("Incoming call alert"); break;
        case 4: System.out.print("Composer"); break;
        case 5: System.out.print("Message alert tone"); break;
        case 6: System.out.print("Keypad tones"); break;
        case 7: System.out.print("Warning and game tones"); break;
        case 8: System.out.print("Vibrating alert"); break;
        case 9: System.out.print("Screen saver"); break;
        case 0: 
          Nokia.menu();          
          System.out.print(String.format("\033[2J"));
          break;
        default: 
          Nokia.menu();          
          System.out.print(String.format("\033[2J"));
          break;
      }
        
  }
}
