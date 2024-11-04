import java.util.Scanner;

public class Nokia{
  public static void main(String[] args){
    menu();
  }
  
  public static void menu(){
    Scanner scan = new Scanner(System.in);
      String mainMenu = """
      MENU
        1. Phonebook
        2. Messages
        3. Chat
        4. Call register
        5. Tones
        6. Settings
        7. Call divert
        8. Games
        9. Calculator
        10. Reminder
        11. Clock
        12. Profiles
        13. SIM services
        0. Shut Down
        >> """;
      
      System.out.print(mainMenu);
      int mainMenuResponse = scan.nextInt();
      
      switch (mainMenuResponse){
        case 1: Phonebook.menu(); break;
        case 2: Messages.menu(); break;
        case 3: System.out.println("Chat"); break;
        case 4: CallRegister.menu(); break;
        case 5: Tones.menu(); break;
        case 6: Settings.menu(); break;
        case 7: System.out.println("Call divert"); break;
        case 8: System.out.println("Games"); break;
        case 9: System.out.println("Calculator"); break;
        case 10: System.out.println("Reminders"); break;
        case 11: Clock.menu(); break;
        case 12: System.out.println("Profile"); break;
        case 13: System.out.println("SIM Services"); break;
        case 0: System.out.println("Shutting down..."); break;
      }
      
    }
}
