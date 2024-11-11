import java.util.Scanner;

public class Phonebook{
  
  public static void menu(){
    Scanner scan = new Scanner(System.in);
      String mainMenu = """
      Phonebook
        1. Search
        2. Service Nos.
        3. Add name
        4. Erase
        5. Edit
        6. Assign tone
        7. Send b'card
        8. Options
        9. Speed dials
        10. Voice tags
        0: Go to Previous menu
        >> """;
      
      System.out.print(String.format("\033[2J"));
      System.out.print(mainMenu);
      int mainMenuResponse = scan.nextInt();
      
      switch (mainMenuResponse){
        case 1: System.out.print("Search"); break;
        case 2: System.out.print("Service Nos."); break;
        case 3: System.out.print("Add name"); break;
        case 4: System.out.print("Erase"); break;
        case 5: System.out.print("Edit"); break;
        case 6: System.out.print("Assign tone"); break;
        case 7: System.out.print("Send b'card"); break;
        case 8: System.out.print("Options"); break;
        case 9: System.out.print("Speed dials"); break;
        case 10: System.out.print("Voice tags"); break;
        case 0: 
                System.out.print(String.format("\033[2J"));
                Nokia.menu();
        default:   
                System.out.print(String.format("\033[2J"));
                Nokia.menu();
                break;
        
      }
      
      
  } 
}
