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
        >> """;
      
      System.out.print(mainMenu);
      int mainMenuResponse = scan.nextInt();
      
      switch (mainMenuResponse){
        case 1: System.out.print("Search"); break;
        case 2: System.out.print("Search"); break;
        case 3: System.out.print("Search"); break;
        case 4: System.out.print("Search"); break;
        case 5: System.out.print("Search"); break;
        case 6: System.out.print("Search"); break;
        case 7: System.out.print("Search"); break;
        case 8: System.out.print("Search"); break;
        case 9: System.out.print("Search"); break;
        case 10: System.out.print("Search"); break;
        default: System.out.print("Invalid menu no");  break;
        
      }
      
      
  } 
}
