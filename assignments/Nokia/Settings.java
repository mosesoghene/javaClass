import java.util.Scanner;

public class Settings{
  
  public static void menu(){
    Scanner scan = new Scanner(System.in);
    int menuResponse;
      String mainMenu = """
      Settings
        1. Call settings
        2. Phone settings
        3. Security settings
        4. Restore factory settings
        0. Go to previous menu
        >>  """;
      
      System.out.print(String.format("\033[2J"));
      System.out.print(mainMenu);
      menuResponse = scan.nextInt();
      
      switch (menuResponse){
        case 1:              
          System.out.print(String.format("\033[2J"));
          System.out.print("""
            Call settings
            1. Automatic redial
            2. Speed dialling
            3. Call waiting options
            4. Own number sending
            5. Phone line in use
            6. Automatic answer
            0. Go to previous menu
            >  """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Automatic redial"); break;
              case 2: System.out.print("Speed dialling"); break;
              case 3: System.out.print("Call waiting options"); break;
              case 4: System.out.print("Own number sending"); break;
              case 5: System.out.print("Phone line in use"); break;
              case 6: System.out.print("Automatic answer"); break;
              case 0:                
                System.out.print(String.format("\033[2J"));
                menu();
                break;
              default: 
                System.out.print(String.format("\033[2J")); 
                break;
            } break;
            
        case 2: 
          System.out.print(String.format("\033[2J")); 
          System.out.print("""
            Phone settings
            1. Language
            2. Cell info display
            3. Welcome note
            4. Network selection
            5. Lights
            6. Confirm SIM service actions
            0. Go to previous menu
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("Language"); break;
              case 2: System.out.print("Cell info display"); break;
              case 3: System.out.print("Welcome note"); break;
              case 4: System.out.print("Network selection"); break;
              case 5: System.out.print("Lights"); break;
              case 6: System.out.print("Confirm SIM service actions"); break;
              case 0: 
                System.out.print(String.format("\033[2J")); 
                menu();
                break;
              default: 
                System.out.print(String.format("\033[2J")); 
                menu();
                break;
            } break;
            
        case 3: 
          System.out.print(String.format("\033[2J")); 
          System.out.print("""
            Security settings
              1. PIN code request
              2. Call barring service
              3. Fixed dialling
              4. Closed user group
              5. Phone security
              6. Change access codes
              0. Go to previous menu
            > """);
            menuResponse = scan.nextInt();
            switch(menuResponse){
              case 1: System.out.print("PIN code request"); break;
              case 2: System.out.print("Call barring service"); break;
              case 3: System.out.print("Fixed dialling"); break;
              case 4: System.out.print("Closed user group"); break;
              case 5: System.out.print("Phone security"); break;
              case 6: System.out.print("Change access codes"); break;
              default: System.out.print("Invalid menu no.");  break;
            } break;
        case 4: System.out.print("Restore factory settings"); break;
        case 0: 
                System.out.print(String.format("\033[2J"));
                Nokia.menu();
                break;
        default: 
          System.out.print(String.format("\033[2J"));
          Nokia.menu();
          break;
      }
        
  }
}
