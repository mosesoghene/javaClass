import java.util.Scanner;

public class Clock{
  
  public static void menu(){
    Scanner scan = new Scanner(System.in);
    int menuResponse;
      String mainMenu = """
      Clock
        1. Alarm clock
        2. Clock settings
        3. Date setting
        4. Stopwatch
        5. Countdown timer
        6. Auto update of date and time
        >> """;
      
      System.out.print(mainMenu);
      menuResponse = scan.nextInt();
      
      
      switch(menuResponse){
        case 1: System.out.print("Alarm clock"); break;
        case 2: System.out.print("Clock settings"); break;
        case 5: System.out.print("Date setting"); break;
        case 3: System.out.print("Stopwatch"); break;
        case 4: System.out.print("Countdown timer"); break;
        case 6: System.out.print("Auto update of date and time"); break;
        default: System.out.print("Invalid menu no.");  break;
      }
  }
}
