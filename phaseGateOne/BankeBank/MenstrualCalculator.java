import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class MenstrualCalculator {
    private LocalDate flowStartDate;
    private LocalDate flowEndDate;
    private int cycleLength = 28;
    
    public MenstrualCalculator(LocalDate flowStartDate, LocalDate flowEndDate) {
      this.flowStartDate = flowStartDate;
      this.flowEndDate = flowEndDate;
    }
    
    public void setCycleLength(int cycleLength) {
      this.cycleLength = cycleLength;
    }

   
    public int calculateFlowDuration() {
      return Period.between(flowStartDate, flowEndDate).getDays() + 1;
    }

    
    public LocalDate calculateNextPeriodDate() {
      return flowStartDate.plusDays(cycleLength);
    }
    
    public LocalDate calculateOvulationDate() {
      return calculateNextPeriodDate().minusDays(14);
    }
    
    public ArrayList<LocalDate> calculateFertileWindow() {
        ArrayList<LocalDate> fertileWindow = new ArrayList<>();
        LocalDate ovulationDate = calculateOvulationDate();
        
        for (int i = 3; i >= 0; i--) {
            fertileWindow.add(ovulationDate.minusDays(i));
        }
        
        fertileWindow.add(ovulationDate.plusDays(1));
        
        return fertileWindow;
    }
    
   
    public ArrayList<LocalDate> calculateSafePeriod() {
        ArrayList<LocalDate> safePeriod = new ArrayList<>();
        LocalDate fertileStart = calculateOvulationDate().minusDays(5);
        LocalDate fertileEnd = calculateOvulationDate().plusDays(1);
        

        LocalDate currentDate = flowEndDate.plusDays(1);
        while (currentDate.isBefore(fertileStart)) {
            safePeriod.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        

        currentDate = fertileEnd.plusDays(2);
        LocalDate nextPeriod = calculateNextPeriodDate().minusDays(3);
        while (currentDate.isBefore(nextPeriod)) {
            safePeriod.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        
        return safePeriod;
    }
    
    public ArrayList<LocalDate> calculatePreMenstrualSyndromeDays() {
        ArrayList<LocalDate> pmsDays = new ArrayList<>();
        LocalDate nextPeriod = calculateNextPeriodDate();
        
        for (int i = 7; i > 0; i--) {
            pmsDays.add(nextPeriod.minusDays(i));
        }
        
        return pmsDays;
    }
    
    public String getFertilityStatus(LocalDate date) {
        if (date.isEqual(flowStartDate) || 
            (date.isAfter(flowStartDate) && date.isBefore(flowEndDate.plusDays(1)))) {
            return "Menstrual Flow";
        }
        
        if (calculateFertileWindow().contains(date)) {
            if (date.isEqual(calculateOvulationDate())) {
                return "Ovulation Day - Highest Fertility";
            }
            return "Fertile Window - High Fertility";
        }
        
        if (calculateSafePeriod().contains(date)) {
            return "Safe Period - Low Fertility";
        }
        
        if (calculatePreMenstrualSyndromeDays().contains(date)) {
            return "Pre-Menstrual Syndrome Window";
        }
        
        return "Regular Day";
    }
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter Last period start date\n");
      System.out.print("Enter year: ");
      int year = input.nextInt();
      System.out.print("Enter month: ");
      int month = input.nextInt();
      System.out.print("Enter day: ");
      int day = input.nextInt();
        
      LocalDate flowStart = LocalDate.of(year, month, day);
      LocalDate flowEnd = flowStart.plusDays(5);
      
      MenstrualCalculator calculator = new MenstrualCalculator(flowStart, flowEnd);
      
      System.out.println("Flow Duration: " + calculator.calculateFlowDuration() + " days");
      System.out.println("Next Period: " + calculator.calculateNextPeriodDate());
      System.out.println("Ovulation Date: " + calculator.calculateOvulationDate());
      
      System.out.println("\nFertile Window: \n");
      calculator.calculateFertileWindow().forEach(date ->  System.out.println(date + " -> " + calculator.getFertilityStatus(date)));
      
      
      System.out.println("\nSafe Period Days: \n");
      calculator.calculateSafePeriod().forEach(System.out::println);
      
      
      System.out.println("\nPre-Menstrual Syndrome Period: \n");
      calculator.calculatePreMenstrualSyndromeDays().forEach(System.out::println);
    }
}
