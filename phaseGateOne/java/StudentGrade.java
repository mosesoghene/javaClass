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
    
    int[] studentTotals = calculateTotals(scores);
    double[] studentAverages = calculateAverages(studentTotals, subjectNumber);
    int[] positions = calculateStudentPositions(studentTotals);

    displayResultsTable(scores, studentTotals, studentAverages, positions);
    displaySubjectSummaries(scores);
    
    
  }
  
  public static void savingNotice(){
    System.out.println("Saving >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\nSaved succesfully\n");
  }
  
  private static void displaySubjectSummaries(int[][] scores) {
    for (int subject = 0; subject < scores[0].length; subject++) {
      int[] stats = calculateSubjectStatistics(scores, subject);
      System.out.println("\nSubject Summary:");
      System.out.printf("\nSubject %d\n", subject + 1);
      System.out.printf("Highest scoring student is: Student %d Scoring %d\n", stats[2] + 1, stats[0]);
      System.out.printf("Lowest scoring student is: Student %d Scoring %d)\n", stats[3] + 1, stats[1]);      
      System.out.printf("Number of passes: %d\n", stats[4]);
      System.out.printf("Number of Fails: %d\n", scores.length - stats[4]);
    }
  }
  
  private static void displayResultsTable(int[][] scores, int[] totals, double[] averages, int[] positions) {
    System.out.println("\nClass Score Summary:");
    System.out.print("| STUDENT   ");
    for (int i = 1; i <= scores[0].length; i++) {
      System.out.printf("| SUB%2d", i);
    }
    System.out.printf("| %4s | %6s | %2s |\n", "TOT", "AVE", "POS");
    System.out.println("=================================================>>");
    for (int i = 0; i < scores.length; i++) {
      System.out.printf("| Student %d ", (i + 1));
      for (int j = 0; j < scores[i].length; j++) {
        System.out.printf("| %4d ", scores[i][j]);
      }
      System.out.printf("| %4d | %4.2f | %2d |\n", totals[i], averages[i], positions[i]);
    }
  }
    
  
  public static int[][] collectAllScores(int studentNumber, int subjectNumber){
    int[][] scores = new int[studentNumber][subjectNumber];
    for (int i = 0; i < studentNumber; i++) {
      System.out.println("\nEntering scores for Student " + (i + 1));
      for (int j = 0; j < subjectNumber; j++) {
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
  
  private static int[] calculateSubjectStatistics(int[][] scores, int subject) {
    int highest = 0; 
    int lowest = 100;
    int highestStudent = 0; 
    int lowestStudent = 0; 
    int passes = 0;
    
    for (int student = 0; student < scores.length; student++) {
      if (scores[student][subject] > highest) {
        highest = scores[student][subject];
        highestStudent = student;
      }
      if (scores[student][subject] < lowest) {
        lowest = scores[student][subject];
        lowestStudent = student;
      }
      if (scores[student][subject] >= 50) passes++;
    }
    
    return new int[]{highest, lowest, highestStudent, lowestStudent, passes};
  }
  
  private static int[] calculateSubjectPasses(int[][] scores) {
    int[] subjectPasses = new int[scores[0].length];
    for (int j = 0; j < scores[0].length; j++) {
      for (int i = 0; i < scores.length; i++) {
        if (scores[i][j] >= 50) 
          subjectPasses[j]++;
      }
    }
    return subjectPasses;
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
  
  private static int calculateTotalClassScore(int[] totals) {
    int sum = 0;
    for (int total : totals) {
      sum += total;
    }
    return sum;
  }
  
}
