import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;


public class StudentGrade{

  private static Scanner scanner = new Scanner(System.in);
  
  public static void main(String[] args){
  
    Scanner input = new Scanner(System.in);
    
    System.out.println("How many students do you have?");
    int studentNumber = input.nextInt();
    
    System.out.println("How many subjects do they offer?");
    int subjectNumber = input.nextInt();
    savingNotice();
    
    int[][] scores = collectAllScores(studentNumber, subjectNumber);    
    savingNotice();
    
    
    
  }
  
  public static void savingNotice(){
    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved succesfully\n");
  }
  
  private static void displayResultsTable(int[][] scores, int[] totals, double[] averages, int[] positions) {
    System.out.println("\nClass Score Summary:");
    System.out.print("| STUDENT ");
    for (int i = 1; i <= scores[0].length; i++) {
      System.out.printf("| SUB%-4d", i);
    }
    System.out.println("| TOT  |  AVE  |  POSITION");

    for (int i = 0; i < scores.length; i++) {
      System.out.printf("| Student %7d ", (i + 1));
      for (int j = 0; j < scores[i].length; j++) {
        System.out.printf("| %7d", scores[i][j]);
      }
      System.out.printf("| %6d | %6.2f | %d |\n", totals[i], averages[i], positions[i]);
    }
  }
    
  
  public static int[][] collectAllScores(int studentNumber, int subjectNumber){
    int[][] scores = new int[numStudents][numSubjects];
    for (int i = 0; i < numStudents; i++) {
      System.out.println("\nEntering scores for Student " + (i + 1));
      for (int j = 0; j < numSubjects; j++) {
        scores[i][j] = getValidScore(j);
      }
    }
    return scores;
  }
  
  private static int getValidScore(int subject) {
    int score;
    do {
      System.out.print("Enter score for Subject " + (subject + 1) + ": ");
      score = scanner.nextInt();
      if (score < 0 || score > 100) {
        System.out.println("Invalid score! Score must be between 0 and 100.");
      }
    } while (score < 0 || score > 100);
    return score;
  }
  
  public static void printSubjectStatistics(int[][] studentScores){
    int[] totalScores = getTotalScores(studentScores);    
    
    
    int highestScoringStudent = 0;
    int lowestScoringStudent = 0;
    
    for (int i = 0; i < studentScores.length; i++){
      System.out.printf("Subject %d%n", i + 1);
      if (totalScores[totalScores.length - 1] == getTotalOf(studentScores[i])){
        highestScoringStudent = i;
      }
      if (totalScores[i] == getTotalOf(studentScores[i])){
        lowestScoringStudent = i;
      }   
      System.out.printf("Highest Scoring student is: Student %d Scoring %n", highestScoringStudent); 
      System.out.printf("Lowest Scoring student is: Student %d Scoring %n", lowestScoringStudent);
    }
    
    System.out.printf("Best Graduating student is: ");
  }
  
  private static double[] calculateAverages(int[] totals, int numSubjects) {
    double[] averages = new double[totals.length];
    for (int i = 0; i < totals.length; i++) {
      averages[i] = (double) totals[i] / numSubjects;
    }
    return averages;
  }
  
  private static int[] calculateStudentPositions(int[] totals) {
    int[] positions = new int[totals.length];
    for (int i = 0; i < totals.length; i++) {
      int position = 1;
      for (int j = 0; j < totals.length; j++) {
        if (totals[j] > totals[i]) {
          position++;
        }
      }
      positions[i] = position;
    }
    return positions;
  }
  
  private static int[] calculateTotals(int[][] scores) {
    int[] totals = new int[scores.length];
    for (int i = 0; i < scores.length; i++) {
      for (int j = 0; j < scores[i].length; j++) {
        totals[i] += scores[i][j];
      }
    }
    return totals;
  }
  

  
}
