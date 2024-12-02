import java.time.*;
import java.util.Formatter;
import java.util.Scanner;

public class MenstrualCycleCalculator {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
    
      System.out.println("Enter flow date:")      
      System.out.print("Year > ")
      int year = scan.nextInt();   
      
      System.out.print("Month > ")
      int month = scan.nextInt();   
      
      System.out.print("Day > ")
      int day = scan.nextInt();
        LocalDate flowDate = LocalDate.of(year, month, day);

        
        System.out.println(" Month  | Flow Date | Ovulation Date | Safe Period Before Ovulation | Safe Period After Ovulation | Fertile Window | Next Flow Date");
        System.out.println("-----------------------------------------------------------------------------------------");

        
        for (int i = 0; i < 12; i++) {

            LocalDate thisMonthFlowDate = flowDate.plusMonths(i).plusDays(-2);

            LocalDate ovulationDate = thisMonthFlowDate.plusDays(14);

            LocalDate safePeriodBeforeOvulationStart = thisMonthFlowDate.plusDays(7);
            LocalDate safePeriodBeforeOvulationEnd = thisMonthFlowDate.plusDays(10);

            LocalDate safePeriodAfterOvulationStart = ovulationDate.plusDays(3);
            LocalDate safePeriodAfterOvulationEnd = ovulationDate.plusDays(4);

            LocalDate fertileWindowStart = thisMonthFlowDate.plusDays(9);
            LocalDate fertileWindowEnd = ovulationDate.plusDays(1);

            LocalDate nextFlowDate = thisMonthFlowDate.plusDays(28);

            Formatter formatter = new Formatter();
            System.out.println(formatter.format("%6s | %10s | %15s | %25s | %25s | %15s | %13s",
                    getMonthName(thisMonthFlowDate.getMonthValue()),
                    thisMonthFlowDate,
                    ovulationDate,
                    safePeriodBeforeOvulationStart + " - " + safePeriodBeforeOvulationEnd,
                    safePeriodAfterOvulationStart + " - " + safePeriodAfterOvulationEnd,
                    fertileWindowStart + " - " + fertileWindowEnd,
                    nextFlowDate));
        }
    }

    private static String getMonthName(int month) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        return monthNames[month - 1];
    }
}
