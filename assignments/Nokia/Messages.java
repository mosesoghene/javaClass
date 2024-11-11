import java.util.Scanner;

public class Messages{
  static Scanner scan = new Scanner(System.in);
  static int menuResponse;
  
  public static void menu(){
    
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
        0: Go to Previous menu
        >> """;
      
      
      System.out.print(String.format("\033[2J"));
      System.out.print(mainMenu);
      menuResponse = scan.nextInt();
      
      switch (menuResponse){
        case 1: System.out.print("Write messages"); break;
        case 2: System.out.print("Inbox"); break;
        case 3: System.out.print("Outbox"); break;
        case 4: System.out.print("Picture Messages"); break;
        case 5: System.out.print("Templates"); break;
        case 6: System.out.print("Smileys"); break;
        case 7: messageSetting(); break;
          
        case 8: System.out.print("Info service"); break;
        case 9: System.out.print("Voice mailbox number"); break;
        case 10: System.out.print("Service command editor"); break;
        case 0: 
                System.out.print(String.format("\033[2J"));
                Nokia.menu();
        default:  
                System.out.print(String.format("\033[2J"));
                Nokia.menu();
                break;
        
      }
      
      
  } 
  
  public static void messageSetting(){
    int menuResponse;
    
          System.out.print(String.format("\033[2J"));
          System.out.print("""
            Message settings
            1. Set 1
            2. Common
            0: Go to Previous menu
            > """);
            menuResponse = scan.nextInt();
          switch(menuResponse){
            case 1:             
              System.out.print(String.format("\033[2J"));
              System.out.print("""
            Set 1
            1. Message centre number
            2. Message sent as
            3. Message validity
            0. Go to Previous menu
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Message centre number"); break;
              case 2: System.out.print("Message sent as"); break;
              case 3: System.out.print("Message validity"); break;
              case 0: 
                System.out.print(String.format("\033[2J"));
                messageSetting();
                break;
              default: 
                System.out.print(String.format("\033[2J"));
                messageSetting();
                break;
            } break;
            
            case 2:             
              System.out.print(String.format("\033[2J"));
              System.out.print("""
            Common
            1. Delivery reports
            2. Reply via same centre
            3. Character support
            0. Go to Previous menu
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Delivery reports"); break;
              case 2: System.out.print("Reply via same centre"); break;
              case 3: System.out.print("Character support"); break;
              case 0: 
                System.out.print(String.format("\033[2J"));
                messageSetting();
                break;
              default: 
                System.out.print(String.format("\033[2J"));
                messageSetting();
                break;
            } break;
            case 0:  
                System.out.print(String.format("\033[2J"));
                menu();
                break;
            default:  
                System.out.print(String.format("\033[2J"));
                menu();
                break;
          }
  }
}
