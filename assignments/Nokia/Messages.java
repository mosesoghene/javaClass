import java.util.Scanner;

public class Messages{
  
  public static void menu(){
    Scanner scan = new Scanner(System.in);
    int menuResponse;
      String mainMenu = """
      Messages
        1. Write messages
        2. Inbox 
        3. Outbox 
        4. Picture Messages
        5. Templates
        6. Smileys
        7. Message settings
        8. Info service
        9. Voice mailbox number
        10. Service command editor
        >> """;
      
      System.out.print(mainMenu);
      menuResponse = scan.nextInt();
      
      switch (menuResponse){
        case 1: System.out.print("Write messages"); break;
        case 2: System.out.print("Inbox"); break;
        case 3: System.out.print("Outbox"); break;
        case 4: System.out.print("Picture Messages"); break;
        case 5: System.out.print("Templates"); break;
        case 6: System.out.print("Smileys"); break;
        case 7: 
          System.out.print("""
            Message settings
            1. Set 1
            2. Common
            > """);
            menuResponse = scan.nextInt();
          switch(menuResponse){
            case 1: 
              System.out.print("""
            1. Message centre number
            2. Message sent as
            3. Message validity
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Message centre number"); break;
              case 2: System.out.print("Message sent as"); break;
              case 3: System.out.print("Message validity"); break;
              default: System.out.print("Invalid menu no");  break;
            } break;
            
            case 2: 
              System.out.print("""
            1. Delivery reports
            2. Reply via same centre
            3. Character support
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Delivery reports"); break;
              case 2: System.out.print("Reply via same centre"); break;
              case 3: System.out.print("Character support"); break;
              default: System.out.print("Invalid menu no");  break;
            } break;
          }
          break;
          
        case 8: System.out.print("Info service"); break;
        case 9: System.out.print("Voice mailbox number"); break;
        case 10: System.out.print("Service command editor"); break;
        default: System.out.print("Invalid menu no");  break;
        
      }
      
      
  } 
}
