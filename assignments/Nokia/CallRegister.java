import java.util.Scanner;

public class CallRegister{
  
  static Scanner scan = new Scanner(System.in);
  static int menuResponse;
  
  public static void menu(){
      String mainMenu = """
      Call Reister
        1. Missed calls
        2. Received calls 
        3. Dialed numbers 
        4. Erase recent calls lists
        5. Show call duration
        6. Show call costs
        7. call cost settings
        8. Prepaid credit
        0. Go back to previous menu
        >> """;
      
      System.out.print(mainMenu);
      menuResponse = scan.nextInt();
      
      switch (menuResponse){
        case 1: System.out.print("Write messages"); break;
        case 2: System.out.print("Inbox"); break;
        case 3: System.out.print("Outbox"); break;
        case 4: System.out.print("Picture Messages"); break;
        
        case 5: showCallDurationMenu(); break;
            
        case 6: 
          System.out.print("""
            Show call costs
            1. Last call cost
            2. All calls’ cost
            3. Clear counters
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Last call cost"); break;
              case 2: System.out.print("All calls’ cost"); break;
              case 3: System.out.print("Clear counters"); break;
              default: System.out.print("Invalid menu no");  break;
            } break;
            
        case 7:           
          System.out.print("""
            Call cost settings
              1. Call cost limit
              2. Show costs in
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Call cost limit"); break;
              case 2: System.out.print("Show costs in"); break;
              default: System.out.print("Invalid menu no");  break;
            } break;
          
        case 8: System.out.print("Prepaid credit"); break;
        case 0: Nokia.menu();
        default: System.out.print("Invalid menu no");  break;
      }
    
  } 
  
  public static void showCallDurationMenu() {
    
          System.out.print("""
            Show Call Duration 
              1. Last call duration
              2. All calls’ duration
              3. Received calls’ duration
              4. Dialled calls’ duration
              5. Clear timers
              0. Go back to previous menu
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Message centre number"); break;
              case 2: System.out.print("Message sent as"); break;
              case 3: System.out.print("Message validity"); break;
              case 4: System.out.print("Message sent as"); break;
              case 5: System.out.print("Message validity"); break;
              case 0: menu();
              default: System.out.print("Invalid menu no");  break;
            } 
  }
}
