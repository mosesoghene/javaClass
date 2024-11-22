import java.util.Sacnner;

public class Nokia{
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
      >> """);
    
    System.out.print(mainMenu);
    int mainMenuResponse = scan.nextInt();
    
    switch (mainMenuResponse){
      case 1: Phonebook.menu();
    }
}
