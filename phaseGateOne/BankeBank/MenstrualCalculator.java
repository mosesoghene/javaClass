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
        
        for (int i = 5; i >= 0; i--) {
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
        
        
        currentDate = fertileEnd.plusDays(1);
        LocalDate nextPeriod = calculateNextPeriodDate();
        while (currentDate.isBefore(nextPeriod)) {
            safePeriod.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        
        return safePeriod;
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
        

        currentDate = fertileEnd.plusDays(1);
        LocalDate nextPeriod = calculateNextPeriodDate();
        while (currentDate.isBefore(nextPeriod)) {
            safePeriod.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        
        return safePeriod;
    }
    
    public static void main(String[] args) {
        
      LocalDate flowStart = LocalDate.now();
      LocalDate flowEnd = flowStart.plusDays(5);
      
      MenstrualCalculator calculator = new MenstrualCalculator(flowStart, flowEnd);
      
      System.out.println("Flow Duration: " + " days");
      System.out.println("Next Period: " );
      System.out.println("Ovulation Date: " );
      
      System.out.println("\nFertile Window:");
      
      
      System.out.println("\nSafe Period Days:");
      
      
      System.out.println("\nPre-Menstrual Syndrome Period:");
    }
}
